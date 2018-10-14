package com.example.json_web_tokens.api;

import com.example.json_web_tokens.domain.User;
import com.example.json_web_tokens.utils.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-10-14
 */
@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public Map<String, Object> hello(HttpServletRequest request) {
        return JwtUtil.validateTokenAndGetClaims(request);
    }

    @PostMapping("/login")
    public String getToken(@RequestBody User user) {
        return JwtUtil.generateToken(user);
    }
}
