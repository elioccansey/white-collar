package cs425.whitecollar.model.user.role;

import lombok.Data;

import java.util.Set;

@Data
public class LoginResponse {
    private Integer code;
    private String description;
    private Integer userId;
    private String firstName;
    private String lastName;
    private Set<UserRole> role;
    private String token;

    public LoginResponse(Integer code, String description, Integer userId, String firstName, String lastName, Set<UserRole> role, String token) {
        this.code = code;
        this.description = description;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.token = token;
    }

    public LoginResponse(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
