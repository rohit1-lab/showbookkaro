package com.rohit.showBookKaro.services;

import com.rohit.showBookKaro.models.User;
import com.rohit.showBookKaro.repositories.OTPRepository;
import com.rohit.showBookKaro.resouces.OTP;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.ServerResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Async
public class EmailService {

private final OTPRepository otpRepository;
private final JavaMailSender mailSender;
private final TemplateEngine templateEngine;
    public void sendVerificationEmail(User user,String to, String subject, String conformationUrl) throws MessagingException {

        var newToken=generateAndSaveActivationToken(user);

        //actually we are merging the logic  with the email service

        EmailTemplate template = EmailTemplate.ACTIVATE_ACCOUNT;

        sendEmail(to, user.getUsername(), template,conformationUrl,newToken,subject);

    }

    private String generateAndSaveActivationToken(User user) {

        String generatedOTP= generateOTP(6);
        var otp= OTP.builder()
                .code(generatedOTP)
                .createdAt(LocalDateTime.now())
                .ExpiresAt(LocalDateTime.now().plusMinutes(15))
                .user(user)
                .build();
        otpRepository.save(otp);
        return generatedOTP;
    }

    private String generateOTP(int length) {
        String digits = "0123456789";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
//            int index = (int) (Math.random() * digits.length());
            //actually we want to generate cryptographically secured
            //random digit out of digits

            SecureRandom secureRandom = new SecureRandom();

            int index = secureRandom.nextInt(digits.length());
            builder.append(digits.charAt(index));
        }
        return builder.toString();
    }

@Async
protected void sendEmail(String to, String username, EmailTemplate etemplate, String confirmationUrl, String activationCode, String subject) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(
                mimeMessage,
                MimeMessageHelper.MULTIPART_MODE_MIXED
        );
        Map<String,Object> properties=new HashMap<>();
        properties.put("username", username);
        properties.put("confirmationUrl",confirmationUrl);
        properties.put("activationCode",activationCode);
       mimeMessageHelper.setFrom("demoemailforprojects.gmail.com");
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);


        Context context=new Context();
        context.setVariables(properties);
        String template=templateEngine.process(etemplate.getName(),context);
     mimeMessageHelper.setText(template,true);
     mailSender.send(mimeMessage);
    }
}
