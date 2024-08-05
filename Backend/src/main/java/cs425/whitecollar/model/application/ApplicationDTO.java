package cs425.whitecollar.model.application;

import cs425.whitecollar.model.applicationStatus.ApplicationStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ApplicationDTO {
    private long applicationId;
    private long applicantId;
    private long jobId;
    private ApplicationStatus applicationStatus;
    private LocalDate applicationDate;


    public ApplicationDTO() {
    }


    public ApplicationDTO(Application application) {
        this.applicationId = application.getApplicationId();
        this.applicantId = application.getApplicant().getUserId();
        this.jobId = application.getJob().getJobId();
        this.applicationStatus = application.getApplicationStatus();
        this.applicationDate = application.getApplicationDate();
    }
}