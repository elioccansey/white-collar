package cs425.whitecollar.model.application;

import cs425.whitecollar.model.applicant.Applicant;
import cs425.whitecollar.model.applicant.ApplicantRepository;
import cs425.whitecollar.model.applicant.ApplicationService;
import cs425.whitecollar.model.application.dto.ApplicationResponseDTO;
import cs425.whitecollar.model.application.dto.ApplicationResponseDTOMapper;
import cs425.whitecollar.model.job.Job;
import cs425.whitecollar.model.job.JobRepository;
import cs425.whitecollar.model.job.dto.JobResponseDTO;
import cs425.whitecollar.model.user.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final ApplicantRepository applicantRepository;
    private final JobRepository jobRepository;
    private final ApplicationDTOMapper applicationDTOMapper;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ApplicationResponseDTOMapper applicationResponseDTOMapper;

    @Override
    public List<ApplicationResponseDTO> getAllApplications() {
        return applicationRepository.findAll().stream()
                .map(application -> applicationResponseDTOMapper.apply(application))
                .collect(Collectors.toList());
    }


    @Override
    public ApplicationResponseDTO getApplicationById(Integer id) {
        return applicationRepository.findById(Long.valueOf(id))
                .map(applicationResponseDTOMapper)
                .orElseThrow(() -> new RuntimeException("Application not found with id: " + id));
    }


    @Override
    public Collection<ApplicationResponseDTO> getAllApplicationsByApplicantId(Long applicantId) {
        return userRepository.findById(applicantId)
                .filter(user -> user.getRoles().stream()
                        .anyMatch(role -> "ROLE_APPLICANT".equals(role.getName())))
                .map(user -> (Applicant) user)
                .map(Applicant::getApplications)
                .orElseThrow(() -> new RuntimeException("Applicant not found or does not have the role of APPLICANT"))
                .stream()
                .map(applicationResponseDTOMapper)
                .collect(Collectors.toList());
    }












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
