package com.example.library_api.controller;

import com.example.library_api.dto.UserResponseDTO;
import com.example.library_api.entity.User;
import com.example.library_api.mapper.UserMapper;
import com.example.library_api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserService userService;
    private UserMapper userMapper;

    public UserController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserResponseDTO> getUsers() {
        return userService.findAll().stream().map(userMapper::toDTO).toList();

    }
    @GetMapping("/users/{id}")
    public UserResponseDTO getUser(@PathVariable Integer id) {
     User User = userService.findById(id);
     return userMapper.toDTO(User);
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
