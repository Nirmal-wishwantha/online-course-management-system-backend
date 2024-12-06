package com.education.nawamaga.repo;

import com.education.nawamaga.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseMaterialRepo extends JpaRepository<CourseMaterial, Integer> {

    List<CourseMaterial> findByCourseId(int courseId);
}
