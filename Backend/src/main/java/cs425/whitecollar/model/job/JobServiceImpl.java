package cs425.whitecollar.model.job;

import aj.org.objectweb.asm.commons.Remapper;
import cs425.whitecollar.model.user.User;
import cs425.whitecollar.model.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    @Autowired
    private final JobRepository jobRepository;
    @Autowired
    private final JobDTOMapper jobDTOMapper;
    @Autowired
    UserRepository userRepository;

    @Override
    public Collection<JobDTO> getAllJobs() {
        return jobRepository.findAll().stream().map(jobDTOMapper)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<JobDTO> getJobById(Long id) {
        return jobRepository.findById(id).map(jobDTOMapper);
    }

    @Override
    public JobDTO addJob(Job job) {
        Job savedJob = jobRepository.save(job);
        return jobDTOMapper.apply(savedJob);
    }


    @Override
    public Optional<JobDTO> delete(Long id) {
        Optional<Job> existingReviewOpt = jobRepository.findById(id);
        if (existingReviewOpt.isPresent()) {
            jobRepository.deleteById(id);
            return Optional.of(jobDTOMapper.apply(existingReviewOpt.get()));
        } else {
            return Optional.empty();
        }
    }


    public void applyForJob(Long jobId, Long applicantId) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));
        User applicant = userRepository.findById(applicantId)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));

        //my todo
//        job.getApplicants().add(applicant);
        jobRepository.save(job);
    }

    public void cancelApplication(Long jobId, Long applicantId) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));
        User applicant = userRepository.findById(applicantId)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));

        //my todo
        job.getApplicants().remove(applicant);
        jobRepository.save(job);
    }

}
