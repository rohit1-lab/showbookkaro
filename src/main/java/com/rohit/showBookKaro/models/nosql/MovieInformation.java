package com.rohit.showBookKaro.models.nosql;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class MovieInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private LocalDate releaseDate;
    private String genre;
    private String language;
    private String director;
    @OneToMany
    private List<CastMember> casts;

}
