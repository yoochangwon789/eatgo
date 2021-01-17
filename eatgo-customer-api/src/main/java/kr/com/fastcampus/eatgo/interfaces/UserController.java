package kr.com.fastcampus.eatgo.interfaces;

import kr.com.fastcampus.eatgo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class UserController {

    @PostMapping("/users")
    public ResponseEntity<?> create() throws URISyntaxException {
        String email = "tester@example.com";
        String name = "Tester";
        String password = "test";

        User user = User.builder()
                .id(1004L)
                .email(email)
                .name(name)
                .password(password)
                .build();

        String url = "/users/" + user.getId();

        return ResponseEntity.created(new URI(url)).body("{}");
    }
}
