package com.education.nawamaga.repo;

import com.education.nawamaga.dto.CourseDto;
import com.education.nawamaga.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Integer> {

    CourseDto findById(int id);
}
