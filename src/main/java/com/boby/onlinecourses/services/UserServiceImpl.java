package com.boby.onlinecourses.services;

import com.boby.onlinecourses.models.User;
import com.boby.onlinecourses.services.contracts.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void regitserUser(User user, String role) {
        //TODO: check if user exists
        System.out.println("asdasdasda");
        System.out.println(user);
    }
}
