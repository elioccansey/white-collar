package cs425.whitecollar.model.job.dto;


import cs425.whitecollar.model.employer.Employer;
import cs425.whitecollar.model.job.Job;
import cs425.whitecollar.model.user.User;
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
                jobRequestDTO.benefits(),
                new Employer(
                        jobRequestDTO.employer().employerName(),
                        jobRequestDTO.employer().employerInfo()
                )
        );
    }
}
