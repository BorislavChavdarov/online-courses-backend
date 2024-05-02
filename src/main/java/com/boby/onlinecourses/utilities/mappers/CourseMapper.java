package com.boby.onlinecourses.utilities.mappers;

import com.boby.onlinecourses.exceptions.EntityNotFoundException;
import com.boby.onlinecourses.models.Course;
import com.boby.onlinecourses.models.dtos.CourseDto;
import com.boby.onlinecourses.repositories.CategoryRepo;
import com.boby.onlinecourses.repositories.RoleRepo;
import com.boby.onlinecourses.repositories.UserRepoImpl;

public class CourseMapper {
    private final CategoryRepo categoryRepo;
    //private final UserRepoImpl roleRepo;
    //Todo finish - migrate userRepo to JPArepository

    public CourseMapper(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public Course courseDtoToCourse(CourseDto courseDto){
        Course course = new Course();
        course.setCategory(categoryRepo.findById(Integer.parseInt(courseDto.getCategory_id())).orElseThrow(() -> new EntityNotFoundException("Category", Integer.parseInt(courseDto.getCategory_id()))));
        course.setTitle(courseDto.getTitle());



        return course;
    }
}
