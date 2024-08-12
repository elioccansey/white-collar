package cs425.whitecollar.model.applicant.dto;

import cs425.whitecollar.model.applicant.Applicant;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ApplicantResponseDTOMapper implements Function<Applicant, ApplicantResponseDTO> {

    @Override
    public ApplicantResponseDTO apply(Applicant applicant) {
        if (applicant == null) {
            return null;
        }

        return new ApplicantResponseDTO(
                applicant.getFirstName(),
                applicant.getLastName(),
                applicant.getEmail(),
                applicant.getYearsOfExperience()
        );
    }

    @Override
    public <V> Function<V, ApplicantResponseDTO> compose(Function<? super V, ? extends Applicant> before) {
        return Function.super.compose(before);
    }

    @Override
    public <V> Function<Applicant, V> andThen(Function<? super ApplicantResponseDTO, ? extends V> after) {
        return Function.super.andThen(after);
    }
}
