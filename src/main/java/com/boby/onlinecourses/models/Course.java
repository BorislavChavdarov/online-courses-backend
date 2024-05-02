package com.boby.onlinecourses.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer courseId;
    @Column(name = "title", unique = true)
    private String title;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User creator;
//    private LocalDate startingDate;
    @Column(name = "is_published")
    private boolean isPublished;
//    private double passingGrade;
//    private double avgRating;


    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", category=" + category +
                ", creator=" + creator +
                ", isPublished=" + isPublished +
                '}';
    }
}