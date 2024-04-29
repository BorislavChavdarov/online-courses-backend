package com.boby.onlinecourses.services;

import com.boby.onlinecourses.exceptions.EntityDuplicateException;
import com.boby.onlinecourses.exceptions.EntityNotFoundException;
import com.boby.onlinecourses.models.Course;
import com.boby.onlinecourses.models.User;
import com.boby.onlinecourses.repositories.CourseRepoImpl;
import com.boby.onlinecourses.repositories.contracts.CourseRepo;
import com.boby.onlinecourses.services.contracts.CourseService;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class CourseServiceImpl implements CourseService {

private final CourseRepoImpl courseRepo;

    public CourseServiceImpl(CourseRepoImpl courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public void createCourse(Course course) {



        if (courseRepo.findByTitle(course.getTitle())!=null){
            throw new EntityDuplicateException("Course", "title", course.getTitle());
        }

            courseRepo.save(course);






    }

}
