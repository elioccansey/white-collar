package cs425.whitecollar.model.job;

import cs425.whitecollar.model.application.Application;
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
    private Integer jobId;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employer_id")
    private User employer;

//    @ManyToMany(mappedBy = "jobs")
//    private List<Applicant> applicants;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
    private List<Application> applications;

    public Job(Integer jobId, String jobTitle, double yearsOfExperience, String location, double jobSalary, List<String> requireTechnicalSkills, List<String> requireSoftSkills, List<String> benefits, User employer) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.yearsOfExperience = yearsOfExperience;
        this.location = location;
        this.jobSalary = jobSalary;
        this.requireTechnicalSkills = requireTechnicalSkills;
        this.requireSoftSkills = requireSoftSkills;
        this.benefits = benefits;
        this.employer = employer;
    }

    public Job(Integer jobId, String jobTitle, double yearsOfExperience, String location, double jobSalary, List<String> requireTechnicalSkills, List<String> requireSoftSkills, List<String> benefits) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.yearsOfExperience = yearsOfExperience;
        this.location = location;
        this.jobSalary = jobSalary;
        this.requireTechnicalSkills = requireTechnicalSkills;
        this.requireSoftSkills = requireSoftSkills;
        this.benefits = benefits;
    }
}
