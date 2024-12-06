package com.education.nawamaga.service;

import com.education.nawamaga.dto.CourseDto;
import com.education.nawamaga.entity.Course;

import java.util.List;

public interface CourseService {

CourseDto addCourse(CourseDto course);

CourseDto updateCourse(Integer id,CourseDto course);

String deleteCourse(Integer id);

List<CourseDto> getCourseUser(Integer id);

List<CourseDto> getAllCourses();



}
