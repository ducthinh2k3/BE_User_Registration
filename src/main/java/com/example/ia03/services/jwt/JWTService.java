package com.example.ia03.services.jwt;

import java.sql.Date;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.example.ia03.request.LoginRequest;

@Component
@Service
public class JWTService {
    private static final String SECRET_KEY = "thinh";

    public String generateTokenLogin(LoginRequest loginRequest){
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY.getBytes());
        return JWT.create()
                .withSubject(loginRequest.getEmail())
                .withExpiresAt(new Date(System.currentTimeMillis() + 50*60*1000))
                .sign(algorithm);       
    }

    public boolean validateJwtToken(String authToken){
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY.getBytes());
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = verifier.verify(authToken);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Invalid or expired token");
            // return false;
        }
    }

    public String getUserNameFromJwtToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY.getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        return decodedJWT.getSubject();
    }
}
