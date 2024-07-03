package com.rohit.showBookKaro.models;

import com.rohit.showBookKaro.models.Address.Address;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany
    private List<Address> address;



}
