package cs425.whitecollar.model.job;

import cs425.whitecollar.model.applicant.Applicant;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JobDTOMapper implements Function<Job, JobDTO> {

    @Override
    public JobDTO apply(Job job) {
        if (job == null) {
            return null;
        }

        JobDTO jobDTO = new JobDTO();
        jobDTO.setJobId(job.getJobId());
        jobDTO.setJobTitle(job.getJobTitle());
        jobDTO.setLocation(job.getLocation());
        jobDTO.setJobSalary(job.getJobSalary());
        jobDTO.setRequireTechnicalSkills(job.getRequireTechnicalSkills());
        jobDTO.setRequireSoftSkills(job.getRequireSoftSkills());
        jobDTO.setBenefits(job.getBenefits());
        jobDTO.setEmployer(job.getEmployer() != null ? job.getEmployer().getEmployerName() : null);
        jobDTO.setApplicants(job.getApplicants() != null ?
                job.getApplicants().stream().map(Applicant::getUserId).collect(Collectors.toList()) : null);
        return jobDTO;
    }

    @Override
    public <V> Function<V, JobDTO> compose(Function<? super V, ? extends Job> before) {
        return Function.super.compose(before);
    }

    @Override
    public <V> Function<Job, V> andThen(Function<? super JobDTO, ? extends V> after) {
        return Function.super.andThen(after);
    }
}
