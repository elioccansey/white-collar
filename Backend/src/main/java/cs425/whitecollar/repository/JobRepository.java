package cs425.whitecollar.repository;

import cs425.whitecollar.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
