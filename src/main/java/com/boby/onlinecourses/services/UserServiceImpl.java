package com.boby.onlinecourses.services;

import com.boby.onlinecourses.exceptions.EntityDuplicateException;
import com.boby.onlinecourses.exceptions.EntityNotFoundException;
import com.boby.onlinecourses.models.Role;
import com.boby.onlinecourses.models.User;
import com.boby.onlinecourses.repositories.contracts.UserRepo;
import com.boby.onlinecourses.services.contracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public User regitserUser(User user, String roles) {

        boolean duplicateExists = true;
        boolean emailExists = true;
        try {
            userRepo.getByUsername(user.getUsername());
        } catch (EntityNotFoundException e) {
            duplicateExists = false;
        }

        try {
            userRepo.getByEmail(user.getEmail());
        } catch (EntityNotFoundException e) {
            emailExists = false;
        }

        if (duplicateExists) {
            throw new EntityDuplicateException("User", "username", user.getUsername());
        } else if (emailExists) {
            throw new EntityDuplicateException("Email", "email name", user.getEmail());
        } else {
            System.out.println("user service");
            String pass = user.getPassword();
            user.setPassword("{bcrypt}"+passwordEncoder.encode(pass));
            user.setRoles(roles);
            userRepo.register(user);
            return user;
        }



    }
}
