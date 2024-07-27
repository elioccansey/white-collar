package cs425.whitecollar.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Application {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long applicationId;
    @ManyToOne
    private Applicant applicant;
    @ManyToOne
    private Job job;
}
