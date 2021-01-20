package kr.com.fastcampus.eatgo.utils;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String createToken(Long id, String name) {
        //TODO : JJWT 사용!

        return "header.payload.signature";
    }
}
