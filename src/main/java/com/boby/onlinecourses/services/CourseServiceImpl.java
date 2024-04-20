package com.boby.onlinecourses.services;

import com.boby.onlinecourses.exceptions.EntityDuplicateException;
import com.boby.onlinecourses.exceptions.EntityNotFoundException;
import com.boby.onlinecourses.models.Course;
import com.boby.onlinecourses.models.User;
import com.boby.onlinecourses.repositories.contracts.CourseRepo;
import com.boby.onlinecourses.services.contracts.CourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

private final CourseRepo courseRepo;

    public CourseServiceImpl(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public void createCourse(Course course) {

        boolean duplicateExists = true;
        try {
            courseRepo.getByTitle(course.getTitle());
        } catch (EntityNotFoundException e) {
            duplicateExists = false;
        }


        if (duplicateExists) {
            throw new EntityDuplicateException("Course", "title", course.getTitle());
        } else {

            courseRepo.createCourse(course);

        }



    }

}
