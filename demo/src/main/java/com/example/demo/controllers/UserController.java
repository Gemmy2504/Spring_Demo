package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUserById")
    public User getUser(@RequestBody User user) {
        return userService.getById(user.getId());

    }
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @PostMapping("/addUser")
    public Long addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/deleteUser")
    public Boolean deleteUser(@RequestBody User user) {
        return userService.delete(user.getId());
    }

    @PutMapping("/updateUser")
    public Boolean updateUser(@RequestBody User user) {
        return userService.update(user);
    }

    @GetMapping("/get-by-status")
    public User getByStatus(@RequestParam String status) {
        return userService.getByStatus(status);
    }
}
