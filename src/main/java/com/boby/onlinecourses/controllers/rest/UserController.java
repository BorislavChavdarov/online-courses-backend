package com.boby.onlinecourses.controllers.rest;


import com.boby.onlinecourses.models.User;
import com.boby.onlinecourses.models.dtos.UserDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @PostMapping()
    public void registerUser(@RequestBody @Valid UserDto userDto) {
        System.out.println(userDto);
    }

}
