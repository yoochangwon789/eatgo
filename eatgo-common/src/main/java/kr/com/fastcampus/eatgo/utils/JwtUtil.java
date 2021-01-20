package kr.com.fastcampus.eatgo.utils;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String createToken(Long userId, String name) {
        //TODO : JJWT 사용!

        String token = Jwts.builder()
                .claim("userId", userId)
                .claim("name", name)
                .compact();

        return token;
    }
}
