package com.boby.onlinecourses.controllers.rest;

import com.boby.onlinecourses.exceptions.EntityDuplicateException;
import com.boby.onlinecourses.models.Course;
import com.boby.onlinecourses.models.dtos.UserDto;
import com.boby.onlinecourses.services.CourseServiceImpl;
import com.boby.onlinecourses.services.contracts.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course){
        try {

            //TODO fix course controller, service, repo
            courseService.createCourse(course);
            return course;
        } catch (EntityDuplicateException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }
}
