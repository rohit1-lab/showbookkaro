package com.rohit.showBookKaro.models;

import com.rohit.showBookKaro.models.Address.Address;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class CinemaHall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int hallNumber;
    @OneToOne
    private Address address;

    private int capacity;



}
