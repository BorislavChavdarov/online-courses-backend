package com.boby.onlinecourses.services.contracts;

import com.boby.onlinecourses.models.User;

public interface UserService {
    void regitserUser(User user, String role);
}
