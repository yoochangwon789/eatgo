package kr.com.fastcampus.eatgo.filters;

import kr.com.fastcampus.eatgo.utils.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends BasicAuthenticationFilter {

    private JwtUtil jwtUtil;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        super(authenticationManager);
        this.jwtUtil = jwtUtil;
    }

    // TODO : 실제로 JWT 분석 필요함.
    // 필터가 무슨 요청을 할 경우 메서드를 실행하도록 하는데 나는 필터의 관한 메서드를 구현하도록 함


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws IOException, ServletException {
        // 다음 작업으로 계속 연결시키는 구현
        // TODO : JWT
        chain.doFilter(request, response);
    }
}
