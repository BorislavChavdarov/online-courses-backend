package com.boby.onlinecourses.services;


import com.boby.onlinecourses.exceptions.EntityNotFoundException;
import com.boby.onlinecourses.models.SecurityUser;
import com.boby.onlinecourses.models.User;
import com.boby.onlinecourses.repositories.contracts.UserRepo;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    public JpaUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {
            System.out.println("JPA service");
            User user = userRepo.getByUsername(username);
            System.out.println(user.getUsername());
           return new SecurityUser(user);
        } catch (EntityNotFoundException e) {
            throw new UsernameNotFoundException("Username not found: " + username);

        }

    }
}