package com.northfaceclone.authservice.service.impl;

import com.northfaceclone.authservice.entity.Token;
import com.northfaceclone.authservice.entity.Account;
import com.northfaceclone.authservice.repository.AccountRepository;
import com.northfaceclone.authservice.repository.RoleRepository;
import com.northfaceclone.authservice.repository.TokenRepository;
import com.northfaceclone.authservice.security.JwtService;
import com.northfaceclone.authservice.service.AuthenticationService;
import com.northfaceclone.userservice.dto.common.EmailTemplateName;
import com.northfaceclone.userservice.dto.request.AuthenticationRequest;
import com.northfaceclone.userservice.dto.request.AccountRequestDTO;
import com.northfaceclone.userservice.dto.response.AuthenticationResponse;
import com.northfaceclone.authservice.mapper.AccountMapper;
import com.northfaceclone.userservice.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AccountRepository repository;
    private final TokenRepository tokenRepository;
    private final EmailService emailService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final AccountMapper userMapper;

    @Value("${application.mailing.frontend.activation-url}")
    private String activationUrl;

    public void register(AccountRequestDTO request) throws MessagingException {
        var userRole = roleRepository.findByName("USER")
                // todo - Better exception Handling
                .orElseThrow(() -> new IllegalArgumentException("ROLE USER was not Initialized"));
        var user = userMapper.toUser(request);
        user.setRoles(List.of(userRole));
        user.setEnabled(false);
        user.setAccountLocked(false);
        user.setPassword(passwordEncoder.encode(request.password()));

        repository.save(user);
        sendValidationEmail(user);
    }

    private void sendValidationEmail(Account user) throws MessagingException {
        var newToken = generateAndSaveActivationToken(user);
        // Send Email
        emailService.sendEmail(
                user.getEmail(),
                user.getFullName(),
                EmailTemplateName.ACTIVATE_ACCOUNT,
                activationUrl,
                newToken,
                "Account activation"
        );

    }

    private String generateAndSaveActivationToken(Account user) {

        //Generate Token
        String generatedToken = generateActivationCode(6);
        var token = Token.builder()
                .token(generatedToken)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(15))
                .user(user)
                .build();
        tokenRepository.save(token);
        return generatedToken;
    }

    private String generateActivationCode(int length) {
        String characters = "0123456789";
        StringBuilder codeBuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(characters.length());
            codeBuilder.append(characters.charAt(randomIndex));
        }
        return codeBuilder.toString();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var claims = new HashMap<String, Object>();
        var user = ((Account) auth.getPrincipal());
        claims.put("fullName", user.getFullName());
        var jwtToken = jwtService.generateToken(claims, user);
        return AuthenticationResponse.builder()
                .token(jwtToken).build();
    }

    public void activateAccount(String token) throws MessagingException {
        Token savedToken = tokenRepository.findByToken(token)
                // todo: Exception has to be defined
                .orElseThrow(() -> new RuntimeException("Invalid Token"));
        if (LocalDateTime.now().isAfter(savedToken.getExpiresAt())) {
            sendValidationEmail(savedToken.getUser());
            throw new RuntimeException("Activation token has expired. A new Token has been sent to the email.");
        }
        var user = repository.findById(savedToken.getUser().getId())
                .orElseThrow(() -> new UsernameNotFoundException("User Not found!"));
        user.setEnabled(true);
        repository.save(user);
        savedToken.setValidatedAt(LocalDateTime.now());
        tokenRepository.save(savedToken);
    }

}
