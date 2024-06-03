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
    private String category_id;
    @NotNull
    private String title;

    @Override
    public String toString() {
        return "CourseDto{" +
                ", category_id='" + category_id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
