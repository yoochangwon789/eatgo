package kr.com.fastcampus.eatgo.application;

import kr.com.fastcampus.eatgo.domain.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
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
}