package com.boby.onlinecourses.services.contracts;

import com.boby.onlinecourses.models.User;

public interface UserService {
    User regitserUser(User user, String roles);
}
