package com.example.zcsranew.controller;

import com.example.zcsranew.controller.model.User;
import com.example.zcsranew.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000/")

public class UserAPI {

    @Autowired
    private UserRepo userRepo;

    @PatchMapping("/{id}/status")
    public ResponseEntity<User> updateStatus(@PathVariable Long id) {
        User user = userRepo.findById(id).orElseThrow();
        if (user.getStatus().equals("available")) {
            user.setStatus("unavailable");
        } else {
            user.setStatus("available");
        }
        userRepo.save(user);
        return ResponseEntity.ok(user);
    }
//    @Autowired
//    private PasswordEncoder passwordEncoder;

//    @PostMapping("/loginCredentials")
//    public ResponseEntity<User> authenticate(@RequestBody UserRequest loginRequest){
//        Optional<User> optionalUser = userRepo.findByUsername(loginRequest.getUsername());
//        if (optionalUser.isPresent()){
//            User user = optionalUser.get();
//            if (passwordEncoder.matches(loginRequest.getPasword(),user.getPasword())){
//                return ResponseEntity.ok(user);
//            }
//        }
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//    }

    @GetMapping("username/{username}")
    public ResponseEntity<?> byUsername(@PathVariable String username){
        try {
            Optional<User> userOptional = userRepo.findByUsername(username);

            if (userOptional.isPresent()){
                return new ResponseEntity<>(userOptional,HttpStatus.OK);
            }else {
                return new ResponseEntity<>("User not found",HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("Opps",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getByID(@PathVariable int id){
        try {
            Optional<User> optionalUser = userRepo.findById(id);
            if (optionalUser.isPresent()){
                return new ResponseEntity<>(optionalUser, HttpStatus.OK);
            }else {
                return new ResponseEntity<>("No user found ",HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("Something went wrong",HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("add/User")
    public ResponseEntity<?> addUser(@RequestBody User user){
        try {
            User user1 = new User();
            user1.setRole(user.getRole());
            user1.setUsername(user.getUsername());
            user1.setStatus(user.getStatus());
//            user1.setPasword(passwordEncoder.encode(user.getPasword()));
            userRepo.save(user1);

            return  new ResponseEntity<>("inserted",HttpStatus.OK);
        }catch (Exception exception){
            return  new ResponseEntity<>("not inserted",HttpStatus.BAD_REQUEST);//kuincode passwod
        }
    }

    @PostMapping("/add")
    private ResponseEntity<?> add(@RequestBody User user){
        try {
            User user1 = userRepo.save(user);
            return new ResponseEntity<>("Added successfull",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Connection Error",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        try {
            userRepo.deleteById(id);
            return new ResponseEntity<>("User deleted success",HttpStatus.OK);

        }catch (Exception exception){
            return new ResponseEntity<>("Something went wrong try again",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("all/user")
    public ResponseEntity<?> get(){
        try {
            List<User> userList = userRepo.findAll();
            if (userList.isEmpty()){
                return new ResponseEntity<>("No use found",HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(userList,HttpStatus.OK);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("Something went wrong",HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("update/user{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id ,@RequestBody User updateUser){
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            user.setId(updateUser.getId());
            user.setUsername(updateUser.getUsername());
            user.setEmail(updateUser.getEmail());
            user.setRole(updateUser.getRole());
            user.setPasword(updateUser.getPasword());
            user.setFullname(updateUser.getFullname());
            userRepo.save(user);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }else {
            return new ResponseEntity<>("User not found ",HttpStatus.NOT_FOUND);
        }
    }
}




