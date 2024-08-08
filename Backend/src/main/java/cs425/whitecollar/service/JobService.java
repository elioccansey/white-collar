package cs425.whitecollar.service;

import cs425.whitecollar.entity.Job;
import cs425.whitecollar.model.job.JobDTO;

import java.util.Collection;
import java.util.Optional;

public interface JobService {

    public Optional<JobDTO> delete(Long id);

    public  Collection<JobDTO> getAllJobs();

    public Optional<JobDTO> getJobById(Long id);

    JobDTO addJob(Job job);

    void cancelApplication(Long jobId, Long applicantId);

    void applyForJob(Long jobId, Long applicantId);
}
