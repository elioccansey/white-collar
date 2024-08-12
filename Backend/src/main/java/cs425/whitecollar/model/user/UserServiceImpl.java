package cs425.whitecollar.model.user;

import cs425.whitecollar.model.user.role.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;


    @Override
    public ResponseDto register(UserRegisterationDTO userRegisterationDTO, boolean isEmployer) {
        User user = User.getInstance(userRegisterationDTO, isEmployer);
        User savedUser = userRepo.save(user);
        return new ResponseDto(0, "Success", savedUser.getUserId());
    }

    @Override
    public ResponseDto authenticate(String email, String password) {
        Optional<User> user = userRepo.findByEmail(email);
        if (user.isEmpty()) {
            return new ResponseDto(0, "Invalid email or password", 0);
        }
        else if (!user.get().getPassword().equals(password)) {
            return new ResponseDto(0, "Invalid password", 0);
        }



        User savedUser = userRepo.save(user);
        return new ResponseDto(0, "Success", savedUser.getUserId());
    }
}
