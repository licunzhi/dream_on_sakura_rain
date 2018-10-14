package com.example.json_web_tokens.filter;

import com.example.json_web_tokens.utils.JwtUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-09
 */
public class JwtFilter extends OncePerRequestFilter {

    private static final PathMatcher pathMatcher = new AntPathMatcher();
    private String protectUrlPattern = "/api/**";

    public JwtFilter() {
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                    FilterChain filterChain) throws ServletException, IOException {

        try {
            if (isProtectedUrl(httpServletRequest)) {
                Map<String, Object> claims = JwtUtil.validateTokenAndGetClaims(httpServletRequest);
                String role = String.valueOf(claims.get(JwtUtil.ROLE));
                //最关键的部分就是这里, 我们直接注入了
                SecurityContextHolder.getContext().setAuthentication(
                                new UsernamePasswordAuthenticationToken(null, null, Arrays.asList(() -> role)));
            }
        } catch (Exception e) {
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
            return;
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private boolean isProtectedUrl(HttpServletRequest request) {
        return pathMatcher.match(protectUrlPattern, request.getServletPath());
    }
}
