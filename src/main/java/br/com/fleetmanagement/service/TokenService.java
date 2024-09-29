package br.com.fleetmanagement.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.fleetmanagement.entity.Usuario;

@Service
public class TokenService {
    
    @Value("${api.security.token.secret}")
    private String secret;
    
    private Instant genExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
    
    public String generateToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            System.out.println("Valor do TokenService - generateToken - secret: " + secret);
            String token = JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(usuario.getemail())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);
            //System.out.println("Token gerado para o usuário " + usuario.getemail() + " com a role: " + usuario.getRole() + ": " + token);
       return token;
        } catch(JWTCreationException exception) {
            throw new RuntimeException("Erro para gerar o Token", exception);
        }
    }
    
    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            System.out.println("Valor do TokenService - validateToken - secret: " + secret);
            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            return "";
        }
    }
}