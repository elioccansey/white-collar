package cs425.whitecollar.entity;

import cs425.whitecollar.entity.applicant.Applicant;
import cs425.whitecollar.model.application.applicationStatus.ApplicationStatus;
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
    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;
    @Enumerated(EnumType.STRING)
    private ApplicationStatus applicationStatus;
    private LocalDate applicationDate;
}