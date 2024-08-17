package cs425.whitecollar.model.job;

import cs425.whitecollar.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {


    @Query(value = "SELECT u FROM Job u WHERE u.employer = :employer")
    List<Job> findAllByEmployer(@Param("employer") User employer);
}
