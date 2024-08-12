package cs425.whitecollar.model.job.dto;

import cs425.whitecollar.model.employer.Employer;
import cs425.whitecollar.model.employer.dto.EmployerRequestDTO;
import cs425.whitecollar.model.employer.dto.EmployerRequestDTOMapper;
import cs425.whitecollar.model.job.Job;
import cs425.whitecollar.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class JobRequestDTOMapper implements Function<Job, JobRequestDTO> {
    @Autowired
    private EmployerRequestDTOMapper employerDTOMapper;

    @Override
    public JobRequestDTO apply(Job job) {
        if (job == null) {
            return null;
        }

        User user = job.getEmployer();
        EmployerRequestDTO employerRequestDTO = null;

        if (user instanceof Employer) {
            employerRequestDTO = employerDTOMapper.apply((Employer) user);
        }


        return new JobRequestDTO(
            job.getJobTitle(),
            job.getLocation(),
            job.getYearsOfExperience(),
            job.getJobSalary(),
            job.getRequireTechnicalSkills(),
            job.getRequireSoftSkills(),
            job.getBenefits(),
            employerRequestDTO);
    }

    @Override
    public <V> Function<V, JobRequestDTO> compose(Function<? super V, ? extends Job> before) {
        return Function.super.compose(before);
    }

    @Override
    public <V> Function<Job, V> andThen(Function<? super JobRequestDTO, ? extends V> after) {
        return Function.super.andThen(after);
    }
}
