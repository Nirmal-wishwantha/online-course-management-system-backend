package com.education.nawamaga.repo;

import com.education.nawamaga.dto.CourseDto;
import com.education.nawamaga.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course, Integer> {

    List<Course> findByInstructorId(int instructorId);

}
