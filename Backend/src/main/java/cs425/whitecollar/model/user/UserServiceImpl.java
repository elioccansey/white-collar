package cs425.whitecollar.model.user;

import cs425.whitecollar.model.user.role.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public ResponseDto register(UserRegisterationDTO userRegisterationDTO, boolean isEmployer) {

        if (getUserByEmail(userRegisterationDTO.email()).isPresent()){
            return new ResponseDto(-1, "Email already exist", 0);
        }
        User user = User.getInstance(userRegisterationDTO, isEmployer);
        encodePassword(user);
        User savedUser = userRepo.save(user);
        return new ResponseDto(0, "Success", savedUser.getUserId());
    }


    public Optional<User> getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    private void encodePassword(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }
}
