package cs425.whitecollar.model.application;

import cs425.whitecollar.model.applicant.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("api/v1/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/apply")
    public ResponseEntity<ApplicationDTO> applyForJob(Principal principal, @RequestBody ApplicationDTO applicationDTO) {
        ApplicationDTO appliedJob = applicationService.applyForJob(principal, applicationDTO);
        return new ResponseEntity<>(appliedJob, HttpStatus.OK);
    }
}
