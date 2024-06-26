package com.boby.onlinecourses.repositories;



import com.boby.onlinecourses.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface RoleRepo extends JpaRepository<Role, Integer> {


    Role findByRoleType(String roleName);
}