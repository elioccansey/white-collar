package cs425.whitecollar.model.application;

import cs425.whitecollar.model.applicant.Applicant;
import cs425.whitecollar.model.applicationStatus.ApplicationStatus;
import cs425.whitecollar.model.job.Job;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Application {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long applicationId;
    @ManyToOne
    private Applicant applicant;
    @ManyToOne
    private Job job;
    private ApplicationStatus applicationStatus;
    private LocalDate applicationDate;
}