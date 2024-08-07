package cs425.whitecollar.model.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {

    @Autowired
    private JobService jobService;


    @GetMapping
    public ResponseEntity<Collection<JobDTO>> getAllJobs() {
        return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<JobDTO> addJob(@RequestBody Job job) {
        JobDTO jobDTO = jobService.addJob(job);
        return new ResponseEntity<>(jobDTO, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> getJob(@PathVariable("id") Long id) {
        return jobService.getJobById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<JobDTO> deleteJob(@PathVariable Long id) {
        Optional<JobDTO> deletedReviewOpt = jobService.delete(id);
        return deletedReviewOpt
                .map(deletedReview -> new ResponseEntity<>(deletedReview, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/{jobId}/apply/{applicantId}")
    public ResponseEntity<String> applyForJob(@PathVariable Long jobId, @PathVariable Long applicantId) {
        jobService.applyForJob(jobId, applicantId);
        return new ResponseEntity<>("Application submitted successfully.", HttpStatus.OK);
    }

    @DeleteMapping("/{jobId}/cancel/{applicantId}")
    public ResponseEntity<String> cancelApplication(@PathVariable Long jobId, @PathVariable Long applicantId) {
        jobService.cancelApplication(jobId, applicantId);
        return new ResponseEntity<>("Application canceled successfully.", HttpStatus.OK);
    }


}
