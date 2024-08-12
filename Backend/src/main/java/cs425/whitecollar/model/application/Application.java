package cs425.whitecollar.model.application;

import com.fasterxml.jackson.annotation.JsonBackReference;
import cs425.whitecollar.model.application.applicationStatus.ApplicationStatus;
import cs425.whitecollar.model.job.Job;
import cs425.whitecollar.model.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long applicationId;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private User applicant;
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;
    @Enumerated(EnumType.STRING)
    private ApplicationStatus applicationStatus;
    private LocalDate applicationDate;


    public Application(User applicant, Job job, ApplicationStatus applicationStatus, LocalDate applicationDate) {
        this.applicant = applicant;
        this.job = job;
        this.applicationStatus = applicationStatus;
        this.applicationDate = applicationDate;
    }
}