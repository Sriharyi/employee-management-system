package com.sriharyi.ems.authentication.service;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;

import com.sriharyi.ems.authentication.modal.Token;

import io.jsonwebtoken.Claims;

public interface JwtService {

    public String generateToken(UserDetails userDetails);

    public Optional<Token> findTokenByToken(String token);

    public UserDetails loadUserByUserEmail(String userEmail);

    public boolean isTokenValid(String token, UserDetails userDetails);

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails);

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver);

    public String extractUsername(String token);
}
