package kr.com.fastcampus.eatgo.interfaces;

import kr.com.fastcampus.eatgo.application.UserService;
import kr.com.fastcampus.eatgo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class SessionController {

    @Autowired
    private UserService userService;

    @PostMapping("/session")
    public ResponseEntity<SessionResponseDto> create(@RequestBody SessionRequestDto resource) throws URISyntaxException {
        String accessToken = "ACCESSTOKEN";
        String url = "/session";

        String email = resource.getEmail();
        String password = resource.getPassword();

        userService.authenticate(email, password);

        return ResponseEntity.created(new URI(url)).body(SessionResponseDto.builder()
                .accessToken(accessToken)
                .build());
    }
}
