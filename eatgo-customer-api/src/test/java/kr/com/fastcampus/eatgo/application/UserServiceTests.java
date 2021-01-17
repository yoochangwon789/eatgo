package kr.com.fastcampus.eatgo.application;

import kr.com.fastcampus.eatgo.domain.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class UserServiceTests {

    private UserService userServie;

    @Mock
    private UserRepository userRepository;

    @Test
    public void registerUser() {
        String email = "tester@example.com";
        String name = "Tester";
        String password = "test";

        userServie.registerUser(email, name, password);

        verify(userRepository).save(any());
    }
}