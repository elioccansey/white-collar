package cs425.whitecollar.model.employer.dto;


import cs425.whitecollar.model.employer.Employer;
import org.springframework.stereotype.Service;
import java.util.function.Function;

@Service
public class EmployerRequestDTOMapper implements Function<Employer, EmployerRequestDTO> {
    @Override
    public EmployerRequestDTO apply(Employer employer) {
        return new EmployerRequestDTO(
                employer.getEmployerName(),
                employer.getEmployerInfo()
        );
    }

    @Override
    public <V> Function<V, EmployerRequestDTO> compose(Function<? super V, ? extends Employer> before) {
        return Function.super.compose(before);
    }

    @Override
    public <V> Function<Employer, V> andThen(Function<? super EmployerRequestDTO, ? extends V> after) {
        return Function.super.andThen(after);
    }
}
