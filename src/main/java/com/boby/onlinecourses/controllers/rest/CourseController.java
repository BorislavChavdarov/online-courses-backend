package com.boby.onlinecourses.controllers.rest;

import com.boby.onlinecourses.exceptions.EntityDuplicateException;
import com.boby.onlinecourses.models.Course;
import com.boby.onlinecourses.models.dtos.CourseDto;
import com.boby.onlinecourses.services.contracts.CourseService;
import com.boby.onlinecourses.utilities.mappers.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.json.*;

import java.util.Base64;

@RestController
@RequestMapping("api/courses")
public class CourseController {
    private final CourseService courseService;
    private final CourseMapper courseMapper;

    @Autowired
    public CourseController(CourseService courseService, CourseMapper courseMapper) {
        this.courseService = courseService;
        this.courseMapper = courseMapper;
    }

    @PostMapping
    public Course createCourse(@RequestHeader(name="Authorization") String token, @RequestBody CourseDto courseDto){
        try {

            String[] chunks = token.split("\\s+")[1].split("\\.");
            Base64.Decoder decoder = Base64.getUrlDecoder();

            String header = new String(decoder.decode(chunks[0]));
            String payload = new String(decoder.decode(chunks[1]));


            JSONObject obj = new JSONObject(payload);
            String username = obj.getString("sub");


            //TODO check if user has permissions to create course and handle invalid category id
            Course course = courseMapper.courseDtoToCourse(courseDto);
            courseService.createCourse(course, username);
            return course;
        } catch (EntityDuplicateException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }
}
