package com.vitalytyrenko.ecoflights.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    private SecretKey key;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor("super-secure-key-that-has-32-bytes!".getBytes()); // мінімум 32 символи
    }

    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 годин
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractEmailFromHeader(String header) {
        if (header == null || !header.startsWith("Bearer ")) {
            throw new RuntimeException("Token not found or invalid");
        }
        String token = header.substring(7);
        return extractEmail(token);
    }

    public String extractEmail(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}
