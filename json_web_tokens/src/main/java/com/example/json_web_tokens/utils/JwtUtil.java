package com.example.json_web_tokens.utils;

import com.example.json_web_tokens.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author licunzhi
 * @desc 加密验证工具类
 * @date 2018-10-14
 */
public class JwtUtil {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    private static final long EXPIRATION_TIME = 60_000; // 1 hour
    private static final String SECRET = "dream_on_sakura_rain";
    private static final String TOKEN_PREFIX = "Bearer"; // token prefix common sense
    private static final String HEADER_STRING = "Authorization";
    public static final String ROLE = "ROLE";
    private static final String NAME = "name";

    public static String generateToken(User user) {
        //you can put any data in the map
        HashMap<String, Object> map = new HashMap<>();
        map.put(ROLE, user.getRoleId());
        map.put(NAME, user.getName());

        String jwt = Jwts.builder().setClaims(map).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                        .signWith(SignatureAlgorithm.HS512, SECRET).compact();
        return TOKEN_PREFIX + " " + jwt;
    }

    public static Map<String, Object> validateTokenAndGetClaims(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token == null) {
            throw new RuntimeException("Missing token");
        }
        // parse the token. exception when token is invalid
        Map<String, Object> body =
                        Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody();
        return body;
    }
}
