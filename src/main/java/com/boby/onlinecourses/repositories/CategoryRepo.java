package com.boby.onlinecourses.repositories;

import com.boby.onlinecourses.models.Category;
import com.boby.onlinecourses.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepo extends JpaRepository<Category, Integer> {


}