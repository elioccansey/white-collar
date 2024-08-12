package cs425.whitecollar.model.job.dto;

import cs425.whitecollar.model.employer.Employer;
import cs425.whitecollar.model.employer.dto.EmployerRequestDTOMapper;
import cs425.whitecollar.model.employer.dto.EmployerResponseDTO;
import cs425.whitecollar.model.employer.dto.EmployerResponseDTOMapper;
import cs425.whitecollar.model.job.Job;
import cs425.whitecollar.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class JobResponseDTOMapper implements Function<Job, JobResponseDTO> {
    @Autowired
    private  EmployerResponseDTOMapper employerResponseDTOMapper;

    @Autowired
    public JobResponseDTOMapper(EmployerResponseDTOMapper employerResponseDTOMapper) {
        this.employerResponseDTOMapper = employerResponseDTOMapper;
    }

    @Override
    public JobResponseDTO apply(Job job) {
        if (job == null) {
            return null;
        }

        User user = job.getEmployer();
        EmployerResponseDTO employerResponseDTO = null;

        if (user instanceof Employer) {
            employerResponseDTO = employerResponseDTOMapper.apply((Employer) user);
        }

        return new JobResponseDTO(
                job.getJobId(), // Assuming there's a getId() method
                job.getJobTitle(),
                job.getLocation(),
                job.getYearsOfExperience(),
                job.getJobSalary(),
                job.getRequireTechnicalSkills(),
                job.getRequireSoftSkills(),
                job.getBenefits(),
                employerResponseDTO
        );
    }

    @Override
    public <V> Function<V, JobResponseDTO> compose(Function<? super V, ? extends Job> before) {
        return Function.super.compose(before);
    }

    @Override
    public <V> Function<Job, V> andThen(Function<? super JobResponseDTO, ? extends V> after) {
        return Function.super.andThen(after);
    }
}