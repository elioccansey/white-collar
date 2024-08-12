package cs425.whitecollar.model.user;

import cs425.whitecollar.model.user.role.ResponseDto;

import java.util.Optional;

public interface UserService {

    ResponseDto register(UserRegisterationDTO userRegisterationDTO, boolean isEmployer);
    Optional<User> getUserByEmail(String email);
}
