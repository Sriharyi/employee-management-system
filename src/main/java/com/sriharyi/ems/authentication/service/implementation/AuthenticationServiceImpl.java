package com.sriharyi.ems.authentication.service.implementation;

import com.sriharyi.ems.authentication.dto.AuthenticateRequest;
import com.sriharyi.ems.authentication.dto.AuthenticateResponse;
import com.sriharyi.ems.authentication.dto.RegisterRequest;
import com.sriharyi.ems.authentication.enums.Role;
import com.sriharyi.ems.authentication.enums.TokenType;
import com.sriharyi.ems.authentication.modal.Token;
import com.sriharyi.ems.authentication.modal.User;
import com.sriharyi.ems.authentication.repository.TokenRepository;
import com.sriharyi.ems.authentication.repository.UserRepository;
import com.sriharyi.ems.authentication.service.AuthenticationService;
import com.sriharyi.ems.authentication.service.JwtService;
import com.sriharyi.ems.exception.EmailAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticateResponse register(RegisterRequest request) {
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.valueOf(request.getRole().toUpperCase()))
                .build();

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists");
        }
        User savedUser = userRepository.save(user);

        var jwt = jwtService.generateToken(user);

        saveUserToken(savedUser, jwt);

        return AuthenticateResponse.builder()
                .token(jwt)
                .build();
    }

    private void revokeAllUserTokens(User user) {
        List<Token> validUserTokens = tokenRepository.findActiveTokensByUserId(user.getId());

        if (validUserTokens.isEmpty()) {
            return;
        }

        validUserTokens.forEach(
                t -> {
                    t.setExpired(true);
                    t.setRevoked(true);
                });
        tokenRepository.saveAll(validUserTokens);
    }

    private void saveUserToken(User user, String token) {
        Token usertoken = Token.builder()
                .user(user)
                .token(token)
                .tokenType(TokenType.BEARER)
                .revoked(false)
                .expired(false)
                .build();
        if (usertoken != null) {
            tokenRepository.save(usertoken);
        }
    }

    public AuthenticateResponse authenticate(AuthenticateRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticateResponse.builder()
                .token(jwtToken)
                .role(user.getRole().name())
                .build();

    }
}
