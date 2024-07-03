package com.rohit.showBookKaro.resouces;

import com.rohit.showBookKaro.models.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OTP {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
   private Long id;
    private String code;
    LocalDateTime createdAt;
    LocalDateTime ExpiresAt;
    @OneToOne
    User user;

}
