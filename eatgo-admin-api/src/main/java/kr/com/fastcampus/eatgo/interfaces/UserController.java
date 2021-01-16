package kr.com.fastcampus.eatgo.interfaces;

import kr.com.fastcampus.eatgo.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<User> list() {
        return null;
    }

    // 1. User list
    // 2. User create -> 회원 가입
    // 3. User update
    // 4. User delete -> level -> 0; 아무 것도 못 함.
    // (1: customer, 2: restaurant owner, 3: admin
}
