package kr.com.fastcampus.eatgo.application;

import kr.com.fastcampus.eatgo.domain.CategoryRepository;
import kr.com.fastcampus.eatgo.domain.User;
import kr.com.fastcampus.eatgo.domain.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

class UserServiceTests {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    public void setUserServiceUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userRepository);
    }

    @Test
    public void getUsers() {
        setUserServiceUp();

        List<User> mockUsers = new ArrayList<>();
        mockUsers.add(User.builder()
                .email("tester@exmaple.com")
                .name("tester")
                .level(1L)
                .build());

        given(userRepository.findAll()).willReturn(mockUsers);

        List<User> users = userService.getUsers();
        User user = users.get(0);

        assertThat(user.getName(), is("tester"));
    }

    @Test
    public void addUser() {
        setUserServiceUp();

        String email = "admin@exmple.com";
        String name = "Administrator";

        User mockUser = User.builder()
                .email(email)
                .name(name)
                .build();

        given(userRepository.save(any())).willReturn(mockUser);

        User user = userService.addUser(email, name);

        assertThat(user.getName(), is(name));
    }
}