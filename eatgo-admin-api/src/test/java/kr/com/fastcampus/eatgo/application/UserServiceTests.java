package kr.com.fastcampus.eatgo.application;

import kr.com.fastcampus.eatgo.domain.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTests {

    private UserService userService;

    @Test
    public void getUsers() {
        List<User> users = userService.getUsers();

        User user = users.get(0);

        assertThat(user.getName(), is("tester"));
    }
}