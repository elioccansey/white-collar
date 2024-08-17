package cs425.whitecollar.model.job;

import cs425.whitecollar.model.application.Application;
import cs425.whitecollar.model.application.ApplicationRepository;
import cs425.whitecollar.model.application.applicationStatus.ApplicationStatus;
import cs425.whitecollar.model.job.dto.*;
import cs425.whitecollar.model.user.User;
import cs425.whitecollar.model.user.UserRepository;
import cs425.whitecollar.security.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    @Autowired
    private final JobRepository jobRepository;
    @Autowired
    private final JobResponseDTOMapper jobResponseDTOMapper;
    @Autowired
    private final JobRequestDTOMapper jobRequestDTOMapper;
    @Autowired
    private final JobRequestToJobDTOMapper jobRequestToJobDTOMapper;
    @Autowired
    ApplicationRepository applicationRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    private SecurityService securityService;

    @Override
    public Collection<JobResponseDTO> getAllJobs() {
        return jobRepository.findAll().stream().map(jobResponseDTOMapper)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<JobResponseDTO> getJobById(Long id) {
        return jobRepository.findById(id).map(jobResponseDTOMapper);
    }

    @Override
    public JobResponseDTO addJob(JobRequestDTO jobRequestDTO) {
        Optional<User> user = userRepository.findByEmail(securityService.authenticatedUser());

        Job job = jobRequestToJobDTOMapper.apply(jobRequestDTO);
        job.setEmployer(user.get());
        Job savedJob = jobRepository.save(job);
        return jobResponseDTOMapper.apply(savedJob);
    }


    @Override
    public Optional<JobResponseDTO> delete(Long id) {
        Optional<Job> existingReviewOpt = jobRepository.findById(id);
        if (existingReviewOpt.isPresent()) {
            jobRepository.deleteById(id);
            return Optional.of(jobResponseDTOMapper.apply(existingReviewOpt.get()));
        } else {
            return Optional.empty();
        }
    }


    @Override
    public Collection<JobResponseDTO> getAllJobsByEmployerId(Long employerId) {

        Optional<User> user = userRepository.findById(employerId);
        if (user.isEmpty()) {
            throw new RuntimeException("Employer not found or does not have the role of EMPLOYER");
        }
        List<Job> jobList = jobRepository.findAllByEmployer(user.get());
        return jobList.stream().map(jobResponseDTOMapper).collect(Collectors.toList());

    }


    public void applyForJob(Long jobId, Long applicantId) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));
        User user = userRepository.findById(applicantId)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));


        Application application = new Application(
                user,
                job,
                ApplicationStatus.IN_REVIEW,
                LocalDate.now()
        );

        applicationRepository.save(application);
    }


    public void cancelApplication(Long jobId, Long applicantId) {
        Application application = applicationRepository.findApplicationByJobIdAndApplicantId(jobId, applicantId)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        // Remove the application
        applicationRepository.delete(application);
    }

}
