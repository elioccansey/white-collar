package cs425.whitecollar.model.applicant;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import cs425.whitecollar.model.application.Application;
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
@DiscriminatorValue("APPLICANT")
public class Applicant extends User {
    private Long yearsOfExperience;

    @ElementCollection
    @CollectionTable(name = "applicant_technical_skills", joinColumns = @JoinColumn(name = "applicant_id"))
    @Column(name = "technical_skill")
    private List<String> technicalSkillSet;

    @ElementCollection
    @CollectionTable(name = "applicant_soft_skills", joinColumns = @JoinColumn(name = "applicant_id"))
    @Column(name = "soft_skill")
    private List<String> softSkillSet;

//    @ManyToMany
//    @JoinTable(
//            name = "applicant_jobs",
//            joinColumns = @JoinColumn(name = "applicant_id"),
//            inverseJoinColumns = @JoinColumn(name = "job_id")
//    )
    @JsonManagedReference
    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL)
    private List<Application> applications;

}
