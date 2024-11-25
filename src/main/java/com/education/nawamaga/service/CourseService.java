package com.education.nawamaga.service;

import com.education.nawamaga.dto.CourseDto;
import com.education.nawamaga.entity.Course;

import java.util.List;

public interface CourseService {

CourseDto addCourse(CourseDto course);

CourseDto updateCourse(CourseDto course);

CourseDto getCourseUser(int id);

List<CourseDto> getAllCourses();



}
