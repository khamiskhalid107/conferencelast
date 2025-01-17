package com.example.zcsranew.repository;

import com.example.zcsranew.controller.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User ,Integer > {

    //    @Query(value = "SELECT * FROM user WHERE username = :username",nativeQuery = true)
//    Optional<User>findByUsername(String username);

    Optional<User> findByUsername(String username);

    Optional<User> findById(Long id);
}
