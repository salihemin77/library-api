package com.example.library_api.service;

import com.example.library_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserService   {
    User save(User user);
    User findById(Integer id);
    List<User> findAll();
    void deleteById(Integer id);


}
