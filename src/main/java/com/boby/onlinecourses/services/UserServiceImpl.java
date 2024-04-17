package com.boby.onlinecourses.services;

import com.boby.onlinecourses.models.Role;
import com.boby.onlinecourses.models.User;
import com.boby.onlinecourses.repositories.contracts.UserRepo;
import com.boby.onlinecourses.services.contracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public void regitserUser(User user, String role) {
        //TODO: check if user exists

        user.setRole(role);
        userRepo.register(user);
    }
}
