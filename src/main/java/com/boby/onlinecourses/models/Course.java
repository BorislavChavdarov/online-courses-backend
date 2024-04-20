package com.boby.onlinecourses.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer courseId;
    private String title;
    private String category;
    //TODO fix
//    private User creator;
//    private LocalDate startingDate;
//    private boolean isPublished;
//    private double passingGrade;
//    private double avgRating;

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", category=" + category +
                '}';
    }
}