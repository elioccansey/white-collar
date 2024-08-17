package cs425.whitecollar.model.employer;

import cs425.whitecollar.model.job.Job;
import cs425.whitecollar.model.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

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

    @OneToMany(mappedBy = "employer", fetch = FetchType.EAGER)
    private List<Job> jobs;

    public Employer(String employerName, String employerInfo) {
        this.employerName = employerName;
        this.employerInfo = employerInfo;
    }

    public static Employer getEmployer(User user) {
        Employer employer = new Employer();
        BeanUtils.copyProperties(user, employer);
        employer.setUserId(user.getUserId());
        return employer;
    }

}
