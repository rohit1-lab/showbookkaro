package com.rohit.showBookKaro.models;

import com.rohit.showBookKaro.models.enumerations.AccountStatus;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private AccountStatus accountStatus=AccountStatus.ACTIVE;
    @ManyToOne
    private  User user;



}
