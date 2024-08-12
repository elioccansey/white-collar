package cs425.whitecollar.model.user;

import cs425.whitecollar.model.address.Address;
import cs425.whitecollar.model.user.role.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "userId"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<UserRole> roles;

    @OneToOne
    private Address address;



    public static User getInstance(UserRegisterationDTO userRegisterationDTO, boolean isEmployer){
        User user = new User();
        user.setEmail(userRegisterationDTO.email());
        user.setPassword(userRegisterationDTO.password());
        user.setFirstName(userRegisterationDTO.firstName());
        user.setLastName(userRegisterationDTO.lastName());
        if (isEmployer){
            UserRole role = new UserRole();
            role.setName("ROLE_EMPLOYER");
            role.setDescription("Employer role");
            user.setRoles(Set.of(role));
        }
        else {
            UserRole role = new UserRole();
            role.setName("ROLE_APPLICANT");
            role.setDescription("Applicant role");
            user.setRoles(Set.of(role));
        }
        return user;
    }
}
