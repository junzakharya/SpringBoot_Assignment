package com.example.GreenStitch_Assignment.controller;

import com.example.GreenStitch_Assignment.jwt.JwtResponse;
import com.example.GreenStitch_Assignment.jwt.JwtUtil;
import com.example.GreenStitch_Assignment.model.User;
import com.example.GreenStitch_Assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        userService.signup(user.getUsername(), user.getPassword(), user.getEmail());
        return ResponseEntity.ok("User registered successfully.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        UserDetails userDetails = userService.loadUserByUsername(username);
        if (userDetails != null && isPasswordValid(password, userDetails.getPassword())) {
            String token = jwtUtil.generateToken((User) userDetails);

            JwtResponse jwtResponse = new JwtResponse(token);
            return ResponseEntity.ok(new JwtResponse(token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    private boolean isPasswordValid(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }


        @GetMapping("/hello")
        public ResponseEntity<String> hello () {
            return ResponseEntity.ok("Hello from GreenStitch");
        }
    }
