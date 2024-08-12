package cs425.whitecollar.model.user.role;

import com.fasterxml.jackson.annotation.JsonBackReference;
import cs425.whitecollar.model.user.User;
//import cs425.whitecollar.previlege.Privilege;
import cs425.whitecollar.previlege.Privilege;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Entity
@Table(name="roles")
@Data
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToMany(mappedBy = "roles")
//    @JsonBackReference
//    private Collection<User> users;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "roles_privileges",
//            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
//    private Collection<Privilege> privileges;

    private String name;
    private String description;

    public UserRole() {
        super();
    }

    public UserRole(final String name) {
        super();
        this.name = name;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserRole role = (UserRole) obj;
        if (!getName().equals(role.getName())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Role [name=").append(name).append("]").append("[id=").append(id).append("]");
        return builder.toString();
    }
}
