package kr.com.fastcampus.eatgo.application;

import kr.com.fastcampus.eatgo.domain.User;
import kr.com.fastcampus.eatgo.domain.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
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
    public void authenticateWithValidAttributes() {
        setUserServiceUp();

        String email = "tester@example.com";
        String password = "test";

        User mockUser = User.builder().email(email).build();

        given(userRepository.findByEmail(email)).willReturn(Optional.of(mockUser));
        given(passwordEncoder.matches(any(), any())).willReturn(true);

        User user = userService.authenticate(email, password);

        assertThat(user.getEmail(), is(email));
    }

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