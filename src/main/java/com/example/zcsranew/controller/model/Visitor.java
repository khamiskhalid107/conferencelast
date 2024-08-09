package com.example.zcsranew.controller.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Visitor extends User {


//    private int V_id;
//    private String V_name;
    private String V_purpose;
//    private String V_contact;
//    private LocalDateTime checkInTime;
//    private LocalDateTime checkOutTime;

//    public int getV_id() {
//        return V_id;
//    }

//    public void setV_id(int v_id) {
//        V_id = v_id;
//    }

//    public String getV_name() {
//        return V_name;
//    }

//    public void setV_name(String v_name) {
////        V_name = v_name;
////    }

    public String getV_purpose() {
        return V_purpose;
    }

    public void setV_purpose(String v_purpose) {

        V_purpose = v_purpose;
    }

//    public String getV_contact() {
//        return V_contact;
//    }
//
//    public void setV_contact(String v_contact) {
//        V_contact = v_contact;
//    }

//    public LocalDateTime getCheckInTime() {
//        return checkInTime;
//    }
//
//    public void setCheckInTime(LocalDateTime checkInTime) {
//        this.checkInTime = checkInTime;
//    }
//
//    public LocalDateTime getCheckOutTime() {
//        return checkOutTime;
//    }
//
//    public void setCheckOutTime(LocalDateTime checkOutTime) {
//        this.checkOutTime = checkOutTime;
//    }
}
