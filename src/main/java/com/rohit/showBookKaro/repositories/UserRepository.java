package com.rohit.showBookKaro.repositories;

import com.rohit.showBookKaro.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

 public Optional<User> findByEmail(String email);
}
