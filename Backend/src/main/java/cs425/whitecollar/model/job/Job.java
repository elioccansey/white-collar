package cs425.whitecollar.model.job;

import cs425.whitecollar.model.employer.Employer;
import cs425.whitecollar.model.applicant.Applicant;
import cs425.whitecollar.model.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long jobId;
    private String jobTitle;
    private double yearsOfExperience;
    private String location;
    private double jobSalary;
    @ElementCollection
    @CollectionTable(name = "job_technical_skills", joinColumns = @JoinColumn(name = "job_id"))
    @Column(name = "technical_skill")
    private List<String> requireTechnicalSkills;

    @ElementCollection
    @CollectionTable(name = "job_soft_skills", joinColumns = @JoinColumn(name = "job_id"))
    @Column(name = "soft_skill")
    private List<String> requireSoftSkills;

    @ElementCollection
    @CollectionTable(name = "job_benefits", joinColumns = @JoinColumn(name = "job_id"))
    @Column(name = "benefit")
    private List<String> benefits;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private User employer;

    @ManyToMany(mappedBy = "jobs")
    private List<Applicant> applicants;
}
