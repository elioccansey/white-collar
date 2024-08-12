package cs425.whitecollar.model.user;

import cs425.whitecollar.model.user.role.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class AuthenticationController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping()
    public ResponseEntity<ResponseDto> registerEmployer(@RequestParam("email") String email, @RequestParam("password") String password) {
        ResponseDto responseDto = userService.register(userRegisterationDTO, true);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);

    }

}
