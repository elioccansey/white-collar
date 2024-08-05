package cs425.whitecollar.model.applicant;

import cs425.whitecollar.model.job.Job;
import cs425.whitecollar.model.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Applicant extends User {
    private int yearsOfExperience;

    @ElementCollection
    private List<String> technicalSkillSet;

    @ElementCollection
    private List<String> softSkillSet;

    @ManyToMany
    private List<Job> jobs;

}
