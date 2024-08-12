package cs425.whitecollar.model.application;

import cs425.whitecollar.model.applicant.ApplicationService;
import cs425.whitecollar.model.application.dto.ApplicationResponseDTO;
import cs425.whitecollar.model.job.dto.JobResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;

@RestController
@RequestMapping("/api/v1/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    public ResponseEntity<Collection<ApplicationResponseDTO>> getAllApplications() {
        Collection<ApplicationResponseDTO> applications = applicationService.getAllApplications();
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationResponseDTO> getApplicationById(@PathVariable Integer id) {
        ApplicationResponseDTO application = applicationService.getApplicationById(id);
        return new ResponseEntity<>(application, HttpStatus.OK);
    }

    @GetMapping("/applicants/{applicantId}")
    public ResponseEntity<Collection<ApplicationResponseDTO>> getAllApplicationsByApplicantId(@PathVariable Long applicantId) {
        return new ResponseEntity<>(applicationService.getAllApplicationsByApplicantId(applicantId), HttpStatus.OK);
    }


}
