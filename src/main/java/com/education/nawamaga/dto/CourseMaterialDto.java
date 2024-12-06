package com.education.nawamaga.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseMaterialDto {

    private Integer id;
    private String fileName;
    private String fileUrl;
    private Integer courseId;
    private String allFileName;

    public CourseMaterialDto(Integer id, String fileName, String fileUrl, Integer courseId) {
        this.id = id;
        this.fileName = fileName;
        this.fileUrl = fileUrl;
        this.courseId = courseId;
    }

}
