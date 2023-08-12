package com.example.GreenStitch_Assignment.service;

import com.example.GreenStitch_Assignment.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    User signup(String username, String password, String email);
    User findByUsername(String username);

    UserDetails loadUserByUsername(String username);
}
