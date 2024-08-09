package com.example.zcsranew.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VisitorResponse {
    private String V_purpose;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;

}
