package com.education.nawamaga.dto;

import com.education.nawamaga.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {

    private Integer id;
    private String title;
    private String description;
    private Integer instructorId;
    private String massage;

    public CourseDto(Integer id, String title, String description, Integer instructorId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.instructorId = instructorId;
    }
}
