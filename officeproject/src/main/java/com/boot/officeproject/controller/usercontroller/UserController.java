package com.boot.officeproject.controller.usercontroller;


import java.util.List;

import com.boot.officeproject.model.usermodel.User;
import com.boot.officeproject.model.usermodel.UserLogin;
import com.boot.officeproject.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLogin user){
        
        return ResponseEntity.ok(userService.login(user));
    }


    @PostMapping("/signup") 
    public ResponseEntity<User> signup(@RequestBody User user){
        if(user == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        userService.signup(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/user/update/{empCode}") 
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("empCode") String empCode){
        if(user == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        userService.updateUser(user, empCode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/user/{empCode}")
    public User getUserById(@PathVariable("empCode") String empCode){
        return userService.getUserById(empCode);
    }

    @GetMapping("/user")
    public List<User> getUserById(){
        return userService.getAllUser();
    }

}
