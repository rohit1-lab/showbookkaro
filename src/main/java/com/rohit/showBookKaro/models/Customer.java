package com.rohit.showBookKaro.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

public class Customer extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @OneToOne
    private Account account;

}
