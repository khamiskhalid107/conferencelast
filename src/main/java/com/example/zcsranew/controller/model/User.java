package com.example.zcsranew.controller.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String username;
    private String email;
    private String phone;
    private String pasword;
    private String fullname;
    private String Status;

    @Enumerated(EnumType.STRING)
    private Role role;
}
