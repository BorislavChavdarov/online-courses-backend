package com.boby.onlinecourses.utilities.mappers;

import com.boby.onlinecourses.models.User;
import com.boby.onlinecourses.models.dtos.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User userDtoToUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());
        user.setPictureUrl(userDto.getPictureUrl());

        return user;
    }
}
