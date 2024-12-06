package com.education.nawamaga.service.impl;

import com.education.nawamaga.dto.CourseDto;
import com.education.nawamaga.entity.Course;
import com.education.nawamaga.entity.User;
import com.education.nawamaga.repo.CourseRepo;
import com.education.nawamaga.repo.UserRepo;
import com.education.nawamaga.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CourseServiceImpl implements CourseService {

    final UserRepo userRepo;
    final CourseRepo courseRepo;
    @Autowired
    public CourseServiceImpl(UserRepo userRepo, CourseRepo courseRepo) {
        this.userRepo = userRepo;
        this.courseRepo = courseRepo;
    }


    @Override
    public CourseDto addCourse(CourseDto courseDto) {

        User instructor = userRepo.findById(courseDto.getInstructorId())
                .orElseThrow(() -> new RuntimeException("Instructor not found with ID: " + courseDto.getInstructorId()));

        Course course = new Course(
                courseDto.getTitle(),
                courseDto.getDescription(),
                instructor);

        Course savedCourse = courseRepo.save(course);

        return new CourseDto(savedCourse.getId(),
                savedCourse.getTitle(),
                savedCourse.getDescription(),
                savedCourse.getInstructor().getId(),
                "Course added successfully");
    }




    @Override
    public CourseDto updateCourse(Integer courseId,CourseDto courseDto) {

        Course existingCourse = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + courseId));

        existingCourse.setTitle(courseDto.getTitle());
        existingCourse.setDescription(courseDto.getDescription());

        Course updatedCourse = courseRepo.save(existingCourse);

        return new CourseDto(
                updatedCourse.getId(),
                updatedCourse.getTitle(),
                updatedCourse.getDescription(),
                updatedCourse.getInstructor().getId(),
                "Course updated successfully"
        );
    }

    @Override
    public String deleteCourse(Integer id) {

        if(courseRepo.existsById(id)) {
            courseRepo.deleteById(id);
        }

        return "Course deleted successfully";
    }



    @Override
    public List<CourseDto> getCourseUser(Integer id) {

        if (!userRepo.existsById(id)) {
            throw new RuntimeException("User not found with ID: " + id);
        }

        List<Course> instructorCourses = courseRepo.findByInstructorId(id);

        List<CourseDto> allCourse = new ArrayList<>();

        for (Course course : instructorCourses) {
            allCourse.add(new CourseDto(
                    course.getId(),
                    course.getTitle(),
                    course.getDescription(),
                    course.getInstructor().getId()
            ));
        }

        return allCourse;
    }


    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> all = courseRepo.findAll();

        List<CourseDto> allCourse = new ArrayList<>();

        for (Course course : all) {
            allCourse.add(new CourseDto(
                    course.getId(),
                    course.getTitle(),
                    course.getDescription(),
                    course.getInstructor().getId()
            ));
        }
        return allCourse;
    }

}
