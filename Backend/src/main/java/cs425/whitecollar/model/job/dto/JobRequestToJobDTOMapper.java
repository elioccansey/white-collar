package cs425.whitecollar.model.job.dto;


import cs425.whitecollar.model.job.Job;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class JobRequestToJobDTOMapper implements Function<JobRequestDTO, Job> {
    @Override
    public Job apply(JobRequestDTO jobRequestDTO) {
        if (jobRequestDTO == null) {
            return null;
        }

        return new Job(
                null,
                jobRequestDTO.jobTitle(),
                jobRequestDTO.yearsOfExperience(),
                jobRequestDTO.location(),
                jobRequestDTO.jobSalary(),
                jobRequestDTO.requireTechnicalSkills(),
                jobRequestDTO.requireSoftSkills(),
                jobRequestDTO.benefits()
        );
    }
}
