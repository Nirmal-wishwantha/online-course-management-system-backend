package com.education.nawamaga.controller;

import com.education.nawamaga.dto.CourseDto;
import com.education.nawamaga.dto.UserDto;
import com.education.nawamaga.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseController {

    final CourseService courseService;
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }



    @PostMapping()
    public ResponseEntity<CourseDto> addCourse(@RequestBody CourseDto courseDto) {
        CourseDto course = courseService.addCourse(courseDto);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }



    @PutMapping("/{courseId}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable Integer courseId ,@RequestBody CourseDto courseDto)    {

        CourseDto courseDto1 = courseService.updateCourse(courseId, courseDto);

        return new ResponseEntity<>(courseDto1, HttpStatus.OK);

    }
    


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Integer id) {
        String delete = courseService.deleteCourse(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }


    @GetMapping("/instructor/{id}")
    public ResponseEntity<List<CourseDto>> getCourseUser(@PathVariable Integer id) {

        List<CourseDto> courseUser = courseService.getCourseUser(id);

        return new ResponseEntity<>(courseUser, HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<CourseDto>> getAllCourses() {
        List<CourseDto> courseUser = courseService.getAllCourses();
        return new ResponseEntity<>(courseUser, HttpStatus.OK);
    }


}
