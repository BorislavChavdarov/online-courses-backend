package com.boby.onlinecourses.repositories.contracts;

import com.boby.onlinecourses.models.Course;
import com.boby.onlinecourses.models.User;

public interface CourseRepo {
    void createCourse(Course course);
    Course get(int id);

    Course getByTitle(String title);
}
