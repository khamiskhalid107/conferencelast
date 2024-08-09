package com.example.zcsranew.dto;

import lombok.Data;

@Data
public class UserResponse {
    private Integer id;
    private String username;
    private String pasword;
    private String role;
    private String fullname;

}
