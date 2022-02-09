package com.boot.officeproject.service;

import java.util.List;

import com.boot.officeproject.model.usermodel.User;
import com.boot.officeproject.model.usermodel.UserLogin;
import com.boot.officeproject.repository.UserRepository;
import com.boot.officeproject.security.JwtProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService  {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    public String login(UserLogin user){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtProvider.generateToken(authentication);
    }
    
    public void signup(User user){
        User u = new User();
        u.setCompanyCode(user.getCompanyCode());
        u.setEmail(user.getEmail());
        u.setEmployeeCode(user.getEmployeeCode());
        u.setEmployeeName(user.getEmployeeName());
        u.setPassword(encodePassword(user.getPassword()));
        u.setUsername(user.getUsername());
        u.setUserRole(user.getUserRole());
        u.setMobile(user.getMobile());
        u.setCreateDate(java.time.LocalDate.now());
        userRepository.save(u);

    }
    
    public void updateUser(User user, String key){
        User u = userRepository.findById(key).get();
        u.setEmail(user.getEmail());
        u.setEmployeeName(user.getEmployeeName());
        u.setUsername(user.getUsername());
        u.setUserRole(user.getUserRole());
        u.setMobile(user.getMobile());
        u.setUpdateDate(java.time.LocalDate.now());
        userRepository.save(u);
    }
    
    private String encodePassword(String pass){
         return passwordEncoder.encode(pass);
    }

    public User getUserById(String key){
        return userRepository.findById(key).get();
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }
}

