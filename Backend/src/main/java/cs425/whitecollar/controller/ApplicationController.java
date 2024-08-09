package cs425.whitecollar.controller;

import cs425.whitecollar.model.application.ApplicationDTO;
import cs425.whitecollar.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("api/v1/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/{applicantId}/apply")
    public ResponseEntity<ApplicationDTO> applyForJob(Principal principal, @RequestBody ApplicationDTO applicationDTO) {
        ApplicationDTO appliedJob = applicationService.applyForJob(principal, applicationDTO);
        return new ResponseEntity<>(appliedJob, HttpStatus.OK);
    }

    @PutMapping("/{applicantId}/cancel")
    public ApplicationDTO cancelApplication(Principal principal, @PathVariable Long applicantId) {
        return applicationService.cancelApplication(principal, applicantId);
    }

}
