package com.boby.onlinecourses.repositories;

import com.boby.onlinecourses.exceptions.EntityNotFoundException;
import com.boby.onlinecourses.models.Course;
import com.boby.onlinecourses.models.User;
import com.boby.onlinecourses.repositories.contracts.CourseRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepoImpl extends JpaRepository<Course, Integer>, JpaSpecificationExecutor<Course> {


    Course findByTitle(String title);
}