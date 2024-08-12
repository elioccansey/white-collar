package cs425.whitecollar.model.employer.dto;

import cs425.whitecollar.model.employer.Employer;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class EmployerResponseDTOMapper implements Function<Employer, EmployerResponseDTO> {
    @Override
    public EmployerResponseDTO apply(Employer employer) {
        if (employer == null) {
            return null;
        }

        return new EmployerResponseDTO(
                 employer.getUserId(),
                employer.getEmployerName(),
                employer.getEmployerInfo()
        );
    }

    @Override
    public <V> Function<V, EmployerResponseDTO> compose(Function<? super V, ? extends Employer> before) {
        return Function.super.compose(before);
    }

    @Override
    public <V> Function<Employer, V> andThen(Function<? super EmployerResponseDTO, ? extends V> after) {
        return Function.super.andThen(after);
    }
}
