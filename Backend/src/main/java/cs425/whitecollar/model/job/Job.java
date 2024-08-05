package cs425.whitecollar.model.job;

import cs425.whitecollar.model.employer.Employer;
import cs425.whitecollar.model.applicant.Applicant;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Job {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long jobId;
    private String jobTitle;
    private String location;
    private double jobSalary;
    @ElementCollection
    private List<String> requireTechnicalSkills;
    @ElementCollection
    private List<String> requireSoftSkills;
    @ElementCollection
    private List<String> benefits;

    @ManyToOne
    private Employer employer;
    @ManyToMany
    private List<Applicant> applicants;
}
