package com.boot.officeproject.service;

import java.util.Collection;
import java.util.Collections;

import com.boot.officeproject.model.User;
import com.boot.officeproject.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        User user  = userRepository.findByUsername(username).orElseThrow(()->
            new UsernameNotFoundException("No user Found "+username));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                                                                    true, true, true, true,
                                                                    getAuthorites(user.getUserRole()));
    }

    public Collection<? extends GrantedAuthority> getAuthorites(String role){
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }
    
}
