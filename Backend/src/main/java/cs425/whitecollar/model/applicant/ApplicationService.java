package cs425.whitecollar.model.applicant;


import cs425.whitecollar.model.application.Application;
import cs425.whitecollar.model.application.ApplicationDTO;
import cs425.whitecollar.model.application.dto.ApplicationResponseDTO;
import cs425.whitecollar.model.job.dto.JobResponseDTO;

import java.security.Principal;
import java.util.Collection;

public interface ApplicationService {
    ApplicationDTO applyForJob(Principal principal, ApplicationDTO applicationDTO);

    ApplicationDTO cancelApplication(Principal principal, Long applicantId);

    Collection<ApplicationResponseDTO> getAllApplications();

    ApplicationResponseDTO getApplicationById(Integer id);

    Collection<ApplicationResponseDTO> getAllApplicationsByApplicantId(Long applicantId);
}
