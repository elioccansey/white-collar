package cs425.whitecollar.model.job;

import cs425.whitecollar.model.job.dto.JobRequestDTO;
import cs425.whitecollar.model.job.dto.JobResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/jobs")
@CrossOrigin
public class JobController {

    @Autowired
    private JobService jobService;


    @GetMapping
    public ResponseEntity<Collection<JobResponseDTO>> getAllJobs() {
        return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<JobResponseDTO> addJob(@RequestBody JobRequestDTO jobRequestDTO) {
        JobResponseDTO jobDTO = jobService.addJob(jobRequestDTO);
        return new ResponseEntity<>(jobDTO, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<JobResponseDTO> getJob(@PathVariable("id") Long id) {
        return jobService.getJobById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<JobResponseDTO> deleteJob(@PathVariable Long id) {
        Optional<JobResponseDTO> deletedReviewOpt = jobService.delete(id);
        return deletedReviewOpt
                .map(deletedReview -> new ResponseEntity<>(deletedReview, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/employers/{employerId}")
    public ResponseEntity<Collection<JobResponseDTO>> getAllJobsByEmployerId(@PathVariable Long employerId) {
        return new ResponseEntity<>(jobService.getAllJobsByEmployerId(employerId), HttpStatus.OK);
    }


    @PostMapping("/{jobId}/apply/{applicantId}")
    public ResponseEntity<String> applyForJob(@PathVariable Long jobId, @PathVariable Long applicantId) {
        jobService.applyForJob(jobId, applicantId);
        return new ResponseEntity<>("Application submitted successfully.", HttpStatus.OK);
    }

    @PostMapping("/{jobId}/cancel/{applicantId}")
    public ResponseEntity<String> cancelApplication(@PathVariable Long jobId, @PathVariable Long applicantId) {
        jobService.cancelApplication(jobId, applicantId);
        return new ResponseEntity<>("Application canceled successfully.", HttpStatus.OK);
    }


}
