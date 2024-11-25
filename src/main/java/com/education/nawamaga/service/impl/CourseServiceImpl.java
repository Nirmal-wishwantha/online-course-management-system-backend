package com.education.nawamaga.service.impl;

import com.education.nawamaga.dto.CourseDto;
import com.education.nawamaga.entity.Course;
import com.education.nawamaga.repo.CourseRepo;
import com.education.nawamaga.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    final CourseRepo courseRepo;
    @Autowired
    public CourseServiceImpl(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }


    @Override
    public CourseDto addCourse(CourseDto courseDto) {

        Course save = courseRepo.save(new Course(null, courseDto.getTitle(), courseDto.getDescription(),
                courseDto.getInstructorId()));

        return new CourseDto(save.getId(), save.getTitle(), save.getDescription(), save.getInstructorId());
    }


    @Override
    public CourseDto updateCourse(CourseDto course) {
        return null;
    }

    @Override
    public CourseDto getCourseUser(int id) {

        CourseDto byId = courseRepo.findById(id);
        return byId;

    }

    @Override
    public List<CourseDto> getAllCourses() {
        return List.of();
    }
}
