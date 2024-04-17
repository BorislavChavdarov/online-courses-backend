package com.boby.onlinecourses.repositories.contracts;

import com.boby.onlinecourses.models.User;

public interface UserRepo {
    void register(User user);
}
