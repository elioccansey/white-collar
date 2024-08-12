package cs425.whitecollar.model.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Long> {
    @Query("SELECT a FROM Application a WHERE a.job.jobId = :jobId AND a.applicant.userId = :applicantId")
    Optional<Application> findApplicationByJobIdAndApplicantId(@Param("jobId") Long jobId, @Param("applicantId") Long applicantId);

}
