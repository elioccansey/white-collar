package cs425.whitecollar.model.job;

import cs425.whitecollar.entity.Job;
import org.springframework.stereotype.Service;

import java.util.function.Function;

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
        jobDTO.setEmployerId(job.getEmployer() != null ? job.getEmployer().getUserId() : null);
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
