package cs425.whitecollar.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Employer extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employerId;
    private String employerName;
    private String EmployerInfo;
    @OneToMany
    private List<Job> jobs;
}
