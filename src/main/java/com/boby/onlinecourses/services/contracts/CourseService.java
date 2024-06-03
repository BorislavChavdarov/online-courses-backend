package com.boby.onlinecourses.services.contracts;

import com.boby.onlinecourses.models.Course;

public interface CourseService {
    void createCourse(Course course, String username);
}
