package com.boot.officeproject.repository;

import java.util.Optional;

import com.boot.officeproject.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
 
    public Optional<User> findByUsername(String username);

    public Optional<User> findByEmail(String email); 
     
    public Optional<User> findByResetPasswordToken(String token);

}
