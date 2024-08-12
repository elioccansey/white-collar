package cs425.whitecollar.model.application.dto;

import cs425.whitecollar.model.applicant.dto.ApplicantResponseDTO;
import cs425.whitecollar.model.applicant.dto.ApplicantResponseDTOMapper;
import cs425.whitecollar.model.application.Application;
import cs425.whitecollar.model.job.dto.JobResponseDTO;
import cs425.whitecollar.model.job.dto.JobResponseDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ApplicationResponseDTOMapper implements Function<Application, ApplicationResponseDTO> {

    @Autowired
    private ApplicantResponseDTOMapper applicantResponseDTOMapper;

    @Autowired
    private JobResponseDTOMapper jobResponseDTOMapper;

    @Override
    public ApplicationResponseDTO apply(Application application) {
        if (application == null) {
            return null;
        }

        return new ApplicationResponseDTO(
                application.getApplicationId(),
                application.getApplicationStatus(),
                application.getApplicationDate(),
//                applicantResponseDTOMapper.apply(application.getApplicant()),
                jobResponseDTOMapper.apply(application.getJob())
        );
    }

    @Override
    public <V> Function<V, ApplicationResponseDTO> compose(Function<? super V, ? extends Application> before) {
        return Function.super.compose(before);
    }

    @Override
    public <V> Function<Application, V> andThen(Function<? super ApplicationResponseDTO, ? extends V> after) {
        return Function.super.andThen(after);
    }
}
