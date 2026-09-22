package com.example.library_api.controller;

import com.example.library_api.entity.User;
import com.example.library_api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findAll();

    }
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Integer id) {
       return userService.findById(id);
    }

    @PostMapping("/users")
    public User createUser( @Valid @RequestBody User user) {
        return userService.save(user);
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
    }



}
