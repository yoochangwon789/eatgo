package kr.com.fastcampus.eatgo.application;

import kr.com.fastcampus.eatgo.domain.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class UserServiceTests {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    public void setUserServiceUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userRepository, passwordEncoder);
    }

    @Test
    public void registerUser() {
        setUserServiceUp();

        String email = "tester@example.com";
        String name = "Tester";
        String password = "test";

        userService.registerUser(email, name, password);

        verify(userRepository).save(any());
    }

//    @Test(expected = EmailExistedException.class)
//    public void registerUserWithExistedEmail() {
//        setUserServiceUp();
//
//        String email = "tester@example.com";
//        String name = "Tester";
//        String password = "test";
//
//        User user = User.builder().build();
//
//        given(userRepository.findByEmail(email)).willReturn(Optional.of(user));
//
//        userService.registerUser(email, name, password);
//
//        verify(userRepository, never()).save(any());
//    }

//    @Test
//    public void authenticateWithNotExistedEmail() {
//        setUserServiceUp();
//
//        String email = "x@example.com";
//        String password = "test";
//
//        given(userRepository.findByEmail(email)).willReturn(Optional.empty());
//
//        userService.authenticate(email, password);
//    }

//    @Test
//    public void authenticateWithWrongPassword() {
//        setUserServiceUp();
//
//        String email = "tester@example.com";
//        String password = "x";
//
//        User mockUser = User.builder().email(email).build();
//
//        given(userRepository.findByEmail(email)).willReturn(Optional.of(mockUser));
//        given(passwordEncoder.matches(any(), any())).willReturn(false);
//
//        userService.authenticate(email, password);
//    }
}