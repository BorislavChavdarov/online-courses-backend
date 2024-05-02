package com.boby.onlinecourses.models.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class CourseDto {
    @NotNull
    private String course_id;
    @NotNull
    private String creator_id;
    @NotNull
    private String category_id;
    @NotNull
    private String title;

    @Override
    public String toString() {
        return "CourseDto{" +
                "course_id='" + course_id + '\'' +
                ", creator_id='" + creator_id + '\'' +
                ", category_id='" + category_id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
