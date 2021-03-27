package com.notebook.userlogin.config;

import com.notebook.userlogin.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTGenerator {
    public Map<String, String> generatorJwtToken(User user) {
        String jwtToken = "";
        jwtToken = Jwts.builder().setSubject(user.getEmail()).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "TopSecret").compact();
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token",jwtToken);
        return tokenMap;
    }
}
