package com.boby.onlinecourses.controllers.rest;


import com.boby.onlinecourses.models.User;
import com.boby.onlinecourses.models.dtos.UserDto;
import com.boby.onlinecourses.services.contracts.UserService;
import com.boby.onlinecourses.utilities.mappers.UserMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserMapper userMapper;
    private final UserService userService;

    @Autowired
    public UserController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }


    @PostMapping()
    public void registerUser(@RequestBody @Valid UserDto userDto) {
        //TODO: error handling
        User user = userMapper.userDtoToUser(userDto);
        String role = userDto.getRole();
        userService.regitserUser(user,role);


    }

}
