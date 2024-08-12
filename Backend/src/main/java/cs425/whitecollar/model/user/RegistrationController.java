package cs425.whitecollar.model.user;

import cs425.whitecollar.model.user.role.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("register")
public class RegistrationController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("employer")
    public ResponseEntity<ResponseDto> registerEmployer(@RequestBody UserRegisterationDTO userRegisterationDTO) {
        ResponseDto responseDto = userService.register(userRegisterationDTO, true);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);

    }


    @PostMapping("applicant")
    public ResponseEntity<ResponseDto> registerApplicant(@RequestBody UserRegisterationDTO userRegisterationDTO) {
        ResponseDto responseDto = userService.register(userRegisterationDTO, false);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);

    }
}
