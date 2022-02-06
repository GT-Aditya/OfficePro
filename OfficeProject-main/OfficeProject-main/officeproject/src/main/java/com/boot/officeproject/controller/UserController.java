package com.boot.officeproject.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.boot.officeproject.model.User;
import com.boot.officeproject.model.UserLogin;
import com.boot.officeproject.service.EmailService;
import com.boot.officeproject.service.UserNotFoundException;
import com.boot.officeproject.service.UserService;
import com.boot.officeproject.service.Utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

    @Autowired
    private EmailService emailService;

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

    @PostMapping("/forgot/{email}")
    public ResponseEntity<String> forgotPassword(@PathVariable("email") String email , HttpServletRequest request){
        try{
        String token = userService.updateResetPasswordToken(email);
        String resetPasswordLink = Utility.getSiteURL(request)+"/reset_password?token="+ token;
        emailService.send(email, resetPasswordLink);
        }
        catch(UserNotFoundException ex){
            ex.printStackTrace();
        }
        return ResponseEntity.badRequest().body("Sent");
    }

    @GetMapping("reset_password")
    public String showResetPasswordForm(@Param(value="token") String token){
        User user = userService.get(token);
        if(user!=null){
            return "Resetted successfully";
        }
        else{
            return "No user exist";
        }
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
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

}
