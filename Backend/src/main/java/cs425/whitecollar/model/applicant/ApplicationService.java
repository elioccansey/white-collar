package cs425.whitecollar.model.applicant;


import cs425.whitecollar.model.application.ApplicationDTO;

import java.security.Principal;

public interface ApplicationService {
    ApplicationDTO applyForJob(Principal principal, ApplicationDTO applicationDTO);
}
