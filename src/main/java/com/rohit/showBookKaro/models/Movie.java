package com.rohit.showBookKaro.models;

import com.rohit.showBookKaro.models.nosql.MovieInformation;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private MovieInformation movieInformation;

    private int duration;

    @ManyToMany
    private Set<City> cities;

}
