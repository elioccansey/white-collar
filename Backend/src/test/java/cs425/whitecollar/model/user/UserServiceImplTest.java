package cs425.whitecollar.model.user;

import cs425.whitecollar.model.address.AddressDTO;
import cs425.whitecollar.model.user.role.ResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @Mock
    private UserRepository userRepo;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void register_whenEmailExists_shouldReturnErrorResponse() {

        UserRegisterationDTO userRegistrationDTO = new UserRegisterationDTO("firstName","lastName", "test@example.com", "password", new AddressDTO("4th North", "Fairfied", "Iowa","1122"));
        when(userRepo.findByEmail(userRegistrationDTO.email())).thenReturn(Optional.of(new User()));

        ResponseDto response = userService.register(userRegistrationDTO, false);

        assertEquals(-1, response.code());
        assertEquals("Email already exist", response.description());
        verify(userRepo, never()).save(any(User.class));
    }

    @Test
    void register_whenEmailDoesNotExist_shouldReturnSuccessResponse() {

        UserRegisterationDTO userRegistrationDTO = new UserRegisterationDTO("firstName","lastName", "test@example.com", "password", new AddressDTO("4th North", "Fairfied", "Iowa","1122"));
        User user = User.getInstance(userRegistrationDTO, false);
        User savedUser = new User();
        savedUser.setUserId(123);
        when(userRepo.findByEmail(userRegistrationDTO.email())).thenReturn(Optional.empty());
        when(passwordEncoder.encode(user.getPassword())).thenReturn("encodedPassword");
        when(userRepo.save(any(User.class))).thenReturn(savedUser);


        ResponseDto response = userService.register(userRegistrationDTO, false);

        assertEquals(0, response.code());
        assertEquals("Success", response.description());
        assertEquals(123, response.userId());
        verify(userRepo).save(any(User.class));
    }
}
