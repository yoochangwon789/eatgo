package kr.com.fastcampus.eatgo.filters;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.io.IOException;
import kr.com.fastcampus.eatgo.utils.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            throws IOException, ServletException, java.io.IOException {
        Authentication authentication = getAuthentication(request);
        if (authentication != null) {
            // 실제로 내가 쓰고있는 컨택트를 사용할 수 있게 된다.
            SecurityContext context = SecurityContextHolder.getContext();
            context.setAuthentication(authentication);
        }
        // TODO : JWT 의 분석을 필요한 작업을 구현 doFilter 는 항상 실행이 되야 함.
        chain.doFilter(request, response);
    }

    // 바로 에러 처리가 가능한 메서드 분리 외부에서 사용되는 Authentication 이 아니라 스프링 내부에서 사용하는 Authentication 임.
    private Authentication getAuthentication(HttpServletRequest request) {
        // 다음 작업으로 계속 연결시키는 구현
        // 실제로는 헤서에서 데이터를 얻어와야함
        String token = request.getHeader("Authorization");
        if (token == null) {
            return null;
        }

        // TODO : JWT 구현  --- JwtUtil 에서 claims 얻기.
        Claims claims = jwtUtil.getClaims(token.substring("Bearer".length()));

        Authentication authentication = new UsernamePasswordAuthenticationToken(claims, null);
        return authentication;
    }
}
