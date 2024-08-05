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
    public Optional<JobDTO> delete(Long id) {
        Optional<Job> existingReviewOpt = jobRepository.findById(id);
        if (existingReviewOpt.isPresent()) {
            jobRepository.deleteById(id);
            return Optional.of(jobDTOMapper.apply(existingReviewOpt.get()));
        } else {
            return Optional.empty();
        }
    }
}
