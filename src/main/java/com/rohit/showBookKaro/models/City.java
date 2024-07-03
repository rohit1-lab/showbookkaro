package com.rohit.showBookKaro.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
public class City {
    @Id
    private Long id;
    private String name;
    @ManyToMany
    private Set<Movie> movieList;
}
