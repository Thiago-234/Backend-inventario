package com.projeto.inventario.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.projeto.inventario.entities.Usuario;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

    private static final String SECRET = "123456";
    private static final long EXPIRATION = 86400000;

    public String gerarToken(Usuario usuario) {
        return Jwts.builder()
            .setSubject(usuario.getUsername())
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
            .signWith(SignatureAlgorithm.HS256, SECRET.getBytes())
            .compact();
    }

    public String getSubject(String token) {
        return Jwts.parser()
            .setSigningKey(SECRET.getBytes())
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
    }
}
