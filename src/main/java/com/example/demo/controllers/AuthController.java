package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthService authService = new AuthService();

    @PostMapping("/login")
    public Optional<User> login(@RequestBody User user) {
        return authService.login(user.getEmail(),user.getPassword());
    }

    @PostMapping("/register")
    public boolean register(@RequestBody User user) {
        return authService.register(user);
    }

}
