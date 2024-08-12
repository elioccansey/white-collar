package cs425.whitecollar.model.job;

import cs425.whitecollar.model.job.dto.JobRequestDTO;
import cs425.whitecollar.model.job.dto.JobResponseDTO;

import java.util.Collection;
import java.util.Optional;

public interface JobService {

    public Optional<JobResponseDTO> delete(Long id);

    public  Collection<JobResponseDTO> getAllJobs();

    public Optional<JobResponseDTO> getJobById(Long id);

    JobResponseDTO addJob(JobRequestDTO jobRequestDTO);

    void cancelApplication(Long jobId, Long applicantId);

    void applyForJob(Long jobId, Long applicantId);

    Collection<JobResponseDTO> getAllJobsByEmployerId(Long employerId);
}
