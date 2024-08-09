package com.example.zcsranew.controller;


import com.example.zcsranew.controller.model.Staff;
import com.example.zcsranew.repository.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Staff/Api")
@CrossOrigin(origins = "http://localhost:3000/")
public class StaffAPI {

    @Autowired
    private StaffRepo staffRepo;

    @GetMapping("/all")
    public ResponseEntity<?> getAllStaff() {
        try {
            List<Staff> staffList = staffRepo.findAll();
            if (staffList.isEmpty()) {
                return new ResponseEntity<>("No staff found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(staffList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStaffById(@PathVariable int id) {
        try {
            Optional<Staff> optionalStaff = staffRepo.findById(id);
            if (optionalStaff.isPresent()) {
                return new ResponseEntity<>(optionalStaff.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No staff found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStaff(@RequestBody Staff staff) {
        try {
            Staff savedStaff = staffRepo.save(staff);
            return new ResponseEntity<>(savedStaff, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error adding staff", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStaff(@PathVariable int id, @RequestBody Staff updatedStaff) {
        try {
            Optional<Staff> staffOptional = staffRepo.findById(id);
            if (staffOptional.isPresent()) {
                Staff staff = staffOptional.get();
                staff.setStaffNo(updatedStaff.getStaffNo());
                staff.setStaffLocation(updatedStaff.getStaffLocation());
                staff.setStaffService(updatedStaff.getStaffService());
                staff.setUsername(updatedStaff.getUsername());
                staff.setFullname(updatedStaff.getFullname());
                staff.setEmail(updatedStaff.getEmail());
                staff.setPasword(updatedStaff.getPasword());
                staffRepo.save(staff);
                return new ResponseEntity<>(staff, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Staff not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating staff", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStaff(@PathVariable int id) {
        try {
            staffRepo.deleteById(id);
            return new ResponseEntity<>("Staff deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting staff", HttpStatus.BAD_REQUEST);
        }
    }
}
