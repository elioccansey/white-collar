package cs425.whitecollar.service.serviceimplementation;

import cs425.whitecollar.entity.applicant.Applicant;
import cs425.whitecollar.entity.Application;
import cs425.whitecollar.model.application.ApplicationDTO;
import cs425.whitecollar.model.application.ApplicationDTOMapper;
import cs425.whitecollar.repository.ApplicantRepository;
import cs425.whitecollar.repository.ApplicationRepository;
import cs425.whitecollar.service.ApplicationService;
import cs425.whitecollar.entity.Job;
import cs425.whitecollar.repository.JobRepository;
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

    @Override
    public ApplicationDTO cancelApplication(Principal principal, Long applicantId) {
        return null;
    }
}
