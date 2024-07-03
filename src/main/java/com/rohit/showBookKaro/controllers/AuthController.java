package com.rohit.showBookKaro.controllers;

import com.rohit.showBookKaro.requests.RegisterationRequest;
import com.rohit.showBookKaro.services.AuthService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.processing.SupportedAnnotationTypes;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;
    @PostMapping("/register")

    public ResponseEntity<?>register(@RequestBody @Validated RegisterationRequest request) throws MessagingException {
        service.register(request);
 return ResponseEntity.ok().build();
    }
}
