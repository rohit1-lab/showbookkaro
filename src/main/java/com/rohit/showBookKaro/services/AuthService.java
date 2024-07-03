package com.rohit.showBookKaro.services;

import com.rohit.showBookKaro.models.User;
import com.rohit.showBookKaro.models.enumerations.Role;
import com.rohit.showBookKaro.repositories.UserRepository;
import com.rohit.showBookKaro.requests.RegisterationRequest;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.rohit.showBookKaro.models.enumerations.Role.USER;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
private final EmailService emailService;


    public void register(RegisterationRequest request) throws MessagingException {
      User user = User.builder().firstName(request.getFirstName())
              .lastName(request.getLastName())
              .email(request.getEmail())
              .role(USER)
              .password(passwordEncoder.encode(request.getPassword())).build();

      userRepository.save(user);

    emailService.sendVerificationEmail(user, user.getEmail(), "email verification ","");

    }


}
