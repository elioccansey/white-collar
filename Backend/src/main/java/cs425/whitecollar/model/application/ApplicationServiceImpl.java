package cs425.whitecollar.model.application;

import cs425.whitecollar.model.applicant.Applicant;
import cs425.whitecollar.model.applicant.ApplicantRepository;
import cs425.whitecollar.model.applicant.ApplicationService;
import cs425.whitecollar.model.job.Job;
import cs425.whitecollar.model.job.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final ApplicantRepository applicantRepository;
    private final JobRepository jobRepository;
    private final ApplicationDTOMapper applicationDTOMapper;
    @Override
    public ApplicationDTO applyForJob(Principal principal, ApplicationDTO applicationDTO) {
        String email = principal.getName();
        Optional<Applicant> applicantOptional = applicantRepository.findByEmail(email);

        if (applicantOptional.isPresent()) {
            Applicant applicant = applicantOptional.get();
            Optional<Job> jobOptional = jobRepository.findById(applicationDTO.getJobId());

            if (jobOptional.isPresent()) {
                Job job = jobOptional.get();

                Application application = new Application();
                application.setApplicant(applicant);
                application.setJob(job);
                application.setApplicationStatus(applicationDTO.getApplicationStatus());
                application.setApplicationDate(applicationDTO.getApplicationDate());

                Application savedApplication = applicationRepository.save(application);
                return applicationDTOMapper.apply(savedApplication);
            } else {
                throw new IllegalArgumentException("Job not found with ID: " + applicationDTO.getJobId());
            }
        } else {
            throw new IllegalArgumentException("Applicant not found with email: " + email);
        }
    }
}
