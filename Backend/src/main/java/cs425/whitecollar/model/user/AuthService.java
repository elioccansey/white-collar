package cs425.whitecollar.model.user;


import cs425.whitecollar.model.user.role.LoginResponse;
import cs425.whitecollar.security.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;


    public LoginResponse handleLogin(String email, String password) {
        LoginResponse response;
        String token;
        try {

            UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(email, password);

            Authentication principal = authManager.authenticate(authInputToken);
            if (principal == null) {
                return new LoginResponse(-1, "Authentication failed");
            }

            LOGGER.info("user {} successfully authenticated", email);
            Optional<User> user = userService.getUserByEmail(email);
            if (user.isEmpty()) {
                return new LoginResponse(-1, "Failed to authenticate user. User not found");
            }

            token = jwtUtil.generateToken(email);
            if (token == null) {
                LOGGER.info("User successfully authenticated but Failed to generate token for {}", email);
            }
            User foundUser = user.get();
            response = new LoginResponse(0, "Success", foundUser.getUserId(), foundUser.getFirstName(), foundUser.getLastName(), foundUser.getRoles(), token);

            return response;
        } catch (AuthenticationException authExc) {
            LOGGER.info("Authentication failed for {}", email);
            return new LoginResponse(-1, "Error occurred during authentication");
        }

    }


}
