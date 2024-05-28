package com.northfaceclone.userservice.service.impl;

import com.northfaceclone.userservice.dto.model.EmailTemplateName;
import com.northfaceclone.userservice.dto.request.RegistrationRequest;
import com.northfaceclone.userservice.models.Token;
import com.northfaceclone.userservice.models.User;
import com.northfaceclone.userservice.repository.RoleRepository;
import com.northfaceclone.userservice.repository.TokenRepository;
import com.northfaceclone.userservice.repository.UserRepository;
import com.northfaceclone.userservice.service.AuthenticationService;
import com.northfaceclone.userservice.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final EmailService emailService;

    @Value("${application.mailing.frontend.activation-url}")
    private String activateUrl;

    public void register(RegistrationRequest request) throws MessagingException {
        var userRole = roleRepository.findByName("USER")
            // todo - Better exception Handling
                .orElseThrow(() -> new IllegalArgumentException("ROLE USER was not Initialized"));
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .enabled(false)
                .accountLocked(false)
                .roles(List.of(userRole))
                .build();
        userRepository.save(user);
        sendValidationEmail(user);
    }

    private void sendValidationEmail(User user) throws MessagingException {
        var newToken = generateAndSaveActivationToken(user);
         // Send Email
        emailService.sendEmail(
                user.getEmail(),
                user.fullName(),
                EmailTemplateName.ACTIVATE_ACCOUNT,
                activateUrl,
                newToken,
                "Account activation"
        );

    }

    private String generateAndSaveActivationToken(User user){

        //Generate Token
        String generatedToken = generateActivationCode(6);
            var token = Token.builder()
                    .token(generatedToken)
                    .createdAt(LocalDateTime.now())
                    .expiresAt(LocalDateTime.now().plusMinutes(15))
                    .user(user)
                    .build();
            tokenRepository.save(token);
            return  generatedToken;
    }

    private String generateActivationCode(int length) {
        String characters = "0123456789";
        StringBuilder codeBuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < length; i++){
            int randomIndex = secureRandom.nextInt(characters.length());
            codeBuilder.append(characters.charAt(randomIndex));
        }
        return codeBuilder.toString();
    }
}
