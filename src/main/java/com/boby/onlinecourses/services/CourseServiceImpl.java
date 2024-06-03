package com.boby.onlinecourses.services;

import com.boby.onlinecourses.exceptions.EntityDuplicateException;
import com.boby.onlinecourses.models.Course;
import com.boby.onlinecourses.repositories.CourseRepoImpl;
import com.boby.onlinecourses.repositories.contracts.UserRepo;
import com.boby.onlinecourses.services.contracts.CourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

        private final CourseRepoImpl courseRepo;
        private final UserRepo userRepo;

    public CourseServiceImpl(CourseRepoImpl courseRepo, UserRepo userRepo) {
        this.courseRepo = courseRepo;
        this.userRepo = userRepo;
    }

    @Override
    public void createCourse(Course course, String username) {

        course.setCreator(userRepo.getByUsername(username));

        if (courseRepo.findByTitle(course.getTitle())!=null){
            throw new EntityDuplicateException("Course", "title", course.getTitle());
        }

            courseRepo.save(course);






    }

}
