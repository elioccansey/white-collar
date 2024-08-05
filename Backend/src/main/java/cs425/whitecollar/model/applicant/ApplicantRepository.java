package cs425.whitecollar.model.applicant;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicantRepository {
    public Optional<Applicant> findByEmail(String email);
}
