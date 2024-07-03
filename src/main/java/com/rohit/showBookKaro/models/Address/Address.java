package com.rohit.showBookKaro.models.Address;

import com.rohit.showBookKaro.models.City;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Embeddable
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    private String addrressLine1 ;
    private String addrressLine2 ;
    @ManyToOne
    private City city;
    private String zipcode;
    private String country;

}
