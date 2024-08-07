package cs425.whitecollar.model.job;

import cs425.whitecollar.model.applicant.Applicant;
import cs425.whitecollar.model.user.User;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class JobDTO {

    private long jobId;
    private String jobTitle;
    private String location;
    private double yearsOfExperience;
    private double jobSalary;
    private List<String> requireTechnicalSkills;
    private List<String> requireSoftSkills;
    private List<String> benefits;
    private Long  employerId;



    public JobDTO() {
    }

    public JobDTO(Job job) {
        this.jobId = job.getJobId();
        this.jobTitle = job.getJobTitle();
        this.yearsOfExperience = job.getYearsOfExperience();
        this.location = job.getLocation();
        this.jobSalary = job.getJobSalary();
        this.requireTechnicalSkills = job.getRequireTechnicalSkills();
        this.requireSoftSkills = job.getRequireSoftSkills();
        this.benefits = job.getBenefits();
        this.employerId = job.getEmployer() != null ? job.getEmployer().getUserId() : null;
    }
}