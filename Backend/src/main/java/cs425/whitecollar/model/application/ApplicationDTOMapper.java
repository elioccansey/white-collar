package cs425.whitecollar.model.application;

import cs425.whitecollar.entity.Application;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ApplicationDTOMapper implements Function<Application, ApplicationDTO> {

    @Override
    public ApplicationDTO apply(Application application) {
        if (application == null) {
            return null;
        }

        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setApplicationId(application.getApplicationId());
        applicationDTO.setApplicantId(application.getApplicant().getUserId());
        applicationDTO.setJobId(application.getJob().getJobId());
        applicationDTO.setApplicationStatus(application.getApplicationStatus());
        applicationDTO.setApplicationDate(application.getApplicationDate());

        return applicationDTO;
    }

    @Override
    public <V> Function<V, ApplicationDTO> compose(Function<? super V, ? extends Application> before) {
        return Function.super.compose(before);
    }

    @Override
    public <V> Function<Application, V> andThen(Function<? super ApplicationDTO, ? extends V> after) {
        return Function.super.andThen(after);
    }
}
