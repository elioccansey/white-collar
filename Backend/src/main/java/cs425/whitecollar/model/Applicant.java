package cs425.whitecollar.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Applicant extends User{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long applicantId;
    private int yearsOfExperience;
    @ElementCollection
    private List<String> technicalSkillSet;
    @ElementCollection
    private List<String> softSkillSet;
    @ManyToMany
    private List<Job> jobs;
}
