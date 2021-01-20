package kr.com.fastcampus.eatgo.application;

import kr.com.fastcampus.eatgo.domain.User;
import kr.com.fastcampus.eatgo.domain.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class UserServiceTests {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    public void setUserServiceUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userRepository);
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

    @Test
    public void authenticateWithValidAttributes() {
        setUserServiceUp();

        String email = "tester@example.com";
        String password = "test";

        User mockUser = User.builder().email(email).build();
        given(userRepository.findByEmail(email)).willReturn(Optional.of(mockUser));

        User user = userService.authenticate(email, password);

        assertThat(user.getEmail(), is(email));
    }

    @Test
    public void authenticateWithNotExistedEmail() {
        setUserServiceUp();

        String email = "x@example.com";
        String password = "test";

        given(userRepository.findByEmail(email)).willReturn(Optional.empty());

        userService.authenticate(email, password);
    }


}