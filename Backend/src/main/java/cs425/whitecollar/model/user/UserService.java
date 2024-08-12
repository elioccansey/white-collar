package cs425.whitecollar.model.user;

import cs425.whitecollar.model.user.role.ResponseDto;

public interface UserService {

    ResponseDto register(UserRegisterationDTO userRegisterationDTO, boolean isEmployer);
}
