package com.example.sistemaMonitoramento.controllers;

import com.example.sistemaMonitoramento.entities.User;
import com.example.sistemaMonitoramento.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public User register(@RequestBody User user) {
        return userService.save(user);
    }
}