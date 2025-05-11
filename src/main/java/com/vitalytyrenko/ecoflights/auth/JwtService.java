package com.vitalytyrenko.ecoflights.auth;

import com.vitalytyrenko.ecoflights.auth._models.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private final String SECRET_KEY = "super-secret-key";

    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("fullName", user.getFullName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 24 години
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}

