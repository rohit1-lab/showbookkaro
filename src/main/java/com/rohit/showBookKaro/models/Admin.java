package com.rohit.showBookKaro.models;

import com.rohit.showBookKaro.models.enumerations.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor


public class Admin extends User {
@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   private Role role;


}
