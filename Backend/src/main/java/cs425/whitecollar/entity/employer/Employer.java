package cs425.whitecollar.entity.employer;

import cs425.whitecollar.entity.Job;
import cs425.whitecollar.entity.user.User;
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
