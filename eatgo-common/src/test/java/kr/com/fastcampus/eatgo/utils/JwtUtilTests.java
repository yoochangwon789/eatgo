package kr.com.fastcampus.eatgo.utils;

import io.jsonwebtoken.Claims;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class JwtUtilTests {

    private static final String SECRET = "12345678901234567890123456789012";

    private JwtUtil jwtUtil;

    public void setUp() {
        jwtUtil = new JwtUtil(SECRET);
    }

    @Test
    public void createToken() {
        setUp();
        String token = jwtUtil.createToken(1004L, "John");

        assertThat(token, containsString("."));
    }

    @Test
    public void getCalims() {
        setUp();
        String token = "...";
        Claims claims = jwtUtil.getClaims(token);

        assertThat(claims.get("name"), is("Tester"));
    }
}