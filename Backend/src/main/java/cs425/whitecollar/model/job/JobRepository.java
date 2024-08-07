package cs425.whitecollar.model.job;

import cs425.whitecollar.model.job.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
