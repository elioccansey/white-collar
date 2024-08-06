package cs425.whitecollar.model.employer;

import cs425.whitecollar.model.job.Job;
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
@DiscriminatorValue("EMPLOYER")
public class Employer extends User {
    private String employerName;
    private String employerInfo;

    @OneToMany(mappedBy = "employer")
    private List<Job> jobs;
}
