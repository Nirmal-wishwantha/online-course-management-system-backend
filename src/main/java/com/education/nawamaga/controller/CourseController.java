package com.education.nawamaga.controller;

import com.education.nawamaga.dto.CourseDto;
import com.education.nawamaga.dto.UserDto;
import com.education.nawamaga.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
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


    
    @GetMapping("/user")
    public ResponseEntity<CourseDto> getCourseUser(@RequestBody Integer id) {
        CourseDto courseUser = courseService.getCourseUser(id);
        return new ResponseEntity<>(courseUser, HttpStatus.OK);

    }


    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Integer id) {

    }

    @PutMapping()
    public void updateCourse(){}

}
