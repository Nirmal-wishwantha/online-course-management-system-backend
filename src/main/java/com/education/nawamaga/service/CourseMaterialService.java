package com.education.nawamaga.service;

import com.education.nawamaga.dto.CourseDto;
import com.education.nawamaga.dto.CourseMaterialDto;
import com.education.nawamaga.dto.CourseMaterialResponseDto;
import com.education.nawamaga.entity.CourseMaterial;
import com.education.nawamaga.service.impl.CourseMaterialImpl;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CourseMaterialService{

    List<CourseMaterialDto> addCourseMaterial(MultipartFile file, Integer id) throws IOException;

    List<CourseMaterialDto> getCourseMaterial(Integer courseId);

    CourseMaterialResponseDto CourseMaterialDelete(Integer id);


}
