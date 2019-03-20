package com.stackroute.userservice.controller;

import com.stackroute.userservice.model.User;
import com.stackroute.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController() {
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
     public ResponseEntity<User> adduser(@RequestBody User user){
        User savedUser=userService.add(user);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> adduser(@RequestBody User user,@PathVariable int id){
        user.setId(id);
        User savedUser=userService.add(user);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @GetMapping("/user")
        public ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id){
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
    }

}
