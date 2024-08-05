package cs425.whitecollar.model.employer;

import cs425.whitecollar.model.job.Job;
import cs425.whitecollar.model.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Employer extends User {
    private String employerName;
    private String employerInfo;

    @OneToMany
    private List<Job> jobs;
}
