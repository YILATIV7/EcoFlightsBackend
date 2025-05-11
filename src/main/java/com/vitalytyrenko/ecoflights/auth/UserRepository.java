package com.vitalytyrenko.ecoflights.auth;

import com.vitalytyrenko.ecoflights.auth._models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
