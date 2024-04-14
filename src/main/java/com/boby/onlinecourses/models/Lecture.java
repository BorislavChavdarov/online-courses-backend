package com.boby.onlinecourses.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Lecture {

    private Integer id;

    private String title;

    private String videoUrl;

    private String assignmentUrl;

    private int courseId;



}