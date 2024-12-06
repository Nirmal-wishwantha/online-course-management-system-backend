package com.education.nawamaga.service.impl;

import com.education.nawamaga.dto.CourseMaterialDto;
import com.education.nawamaga.dto.CourseMaterialResponseDto;
import com.education.nawamaga.entity.Course;
import com.education.nawamaga.entity.CourseMaterial;
import com.education.nawamaga.repo.CourseMaterialRepo;
import com.education.nawamaga.repo.CourseRepo;
import com.education.nawamaga.service.CourseMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseMaterialImpl implements CourseMaterialService {

    private final CourseRepo courseRepo;
    private final CourseMaterialRepo courseMaterialRepo;

    @Autowired
    public CourseMaterialImpl(CourseRepo courseRepo, CourseMaterialRepo courseMaterialRepo) {
        this.courseRepo = courseRepo;
        this.courseMaterialRepo = courseMaterialRepo;
    }

    @Override
    public List<CourseMaterialDto> addCourseMaterial(MultipartFile file, Integer id) throws IOException {
        // Validate Course existence
        Optional<Course> courseOptional = courseRepo.findById(id);
        if (courseOptional.isEmpty()) {
            throw new IllegalArgumentException("Course not found for ID: " + id);
        }
        Course course = courseOptional.get();

        // Upload the file
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename(); // Ensure unique filenames
        Path uploadPath = Paths.get("uploads/", fileName);
        Files.createDirectories(uploadPath.getParent()); // Create directories if they don't exist
        Files.write(uploadPath, file.getBytes());

        // Create and save CourseMaterial entity
        CourseMaterial courseMaterial = new CourseMaterial();
        courseMaterial.setFileName(file.getOriginalFilename());
        courseMaterial.setFileUrl(uploadPath.toString());
        courseMaterial.setCourse(course);
        CourseMaterial savedMaterial = courseMaterialRepo.save(courseMaterial);

        // Convert to DTO and return as a list
        List<CourseMaterialDto> courseMaterials = new ArrayList<>();
        courseMaterials.add(new CourseMaterialDto(
                savedMaterial.getId(),
                savedMaterial.getFileName(),
                savedMaterial.getFileUrl(),
                course.getId(),
                file.getOriginalFilename()
        ));
        return courseMaterials;
    }

    @Override
    public List<CourseMaterialDto> getCourseMaterial(Integer courseId) {

        List<CourseMaterial> materials = courseMaterialRepo.findByCourseId(courseId);

        List<CourseMaterialDto> courseMaterials = new ArrayList<>();

        for (CourseMaterial material : materials) {
            courseMaterials.add(new CourseMaterialDto(
                    material.getId(),
                    material.getFileName(),
                    material.getFileUrl(),
                    courseId
            ));

        }
        return courseMaterials;
    }

    @Override
    public CourseMaterialResponseDto CourseMaterialDelete(Integer id) {

        if (courseMaterialRepo.existsById(id)) {

            courseMaterialRepo.deleteById(id);
            return new CourseMaterialResponseDto(id,"Deleted Successfully");

        }

        return new CourseMaterialResponseDto(id,"Course Material Not Found");

    }


}
