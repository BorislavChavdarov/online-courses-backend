package com.boby.onlinecourses.utilities.mappers;

import com.boby.onlinecourses.exceptions.EntityNotFoundException;
import com.boby.onlinecourses.models.User;
import com.boby.onlinecourses.models.dtos.UserDto;
import com.boby.onlinecourses.repositories.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final RoleRepo roleRepo;

    @Autowired
    public UserMapper(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    public User userDtoToUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());
        user.setPictureUrl(userDto.getPicture_url());

        user.setRole(roleRepo.findById(Integer.parseInt(userDto.getRole_id())).orElseThrow(() -> new EntityNotFoundException("Role", Integer.parseInt(userDto.getRole_id()))));



        return user;
    }
}
