package com.boby.onlinecourses.models;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Course {

    private Integer courseId;
    private String title;
    private Category category;
    private User creator;
    private LocalDate startingDate;
    private boolean isPublished;
    private double passingGrade;
    private double avgRating;



}