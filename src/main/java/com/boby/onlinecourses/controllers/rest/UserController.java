package com.boby.onlinecourses.controllers.rest;



import com.boby.onlinecourses.exceptions.EntityDuplicateException;
import com.boby.onlinecourses.exceptions.EntityNotFoundException;
import com.boby.onlinecourses.models.LoginRequest;
import com.boby.onlinecourses.models.User;
import com.boby.onlinecourses.models.dtos.UserDto;
import com.boby.onlinecourses.services.TokenService;
import com.boby.onlinecourses.services.contracts.UserService;
import com.boby.onlinecourses.utilities.mappers.UserMapper;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(TokenService tokenService, AuthenticationManager authenticationManager, UserService userService, UserMapper userMapper) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @CrossOrigin
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest userLogin) throws AuthenticationException {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.username(), userLogin.password()));
        return tokenService.generateToken(authentication);
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody @Valid UserDto userDto) {





        try {
            User user = userMapper.userDtoToUser(userDto);

            return userService.regitserUser(user);
        } catch (EntityDuplicateException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

}





