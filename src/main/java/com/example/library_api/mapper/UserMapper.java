package com.example.library_api.mapper;

import com.example.library_api.dto.UserResponseDTO;

import com.example.library_api.entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDTO toDTO(User user) {
        return new UserResponseDTO(
                user.getFirstName(),
                user.getId(),
                user.getLastName()



        );

    }
}
