package com.education.nawamaga.controller;

import com.education.nawamaga.dto.CourseMaterialDto;
import com.education.nawamaga.dto.CourseMaterialResponseDto;
import com.education.nawamaga.service.CourseMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/material")
@CrossOrigin
public class CourseMaterialController {

     private final CourseMaterialService courseMaterialService;

     @Autowired
    public CourseMaterialController(CourseMaterialService courseMaterialService) {
        this.courseMaterialService = courseMaterialService;
    }

    @PostMapping("/{id}")
    public ResponseEntity <List<CourseMaterialDto>> AddCourseMaterial(@RequestParam ("file") MultipartFile file, @PathVariable Integer id) throws IOException {
        List<CourseMaterialDto> courseMaterialList = courseMaterialService.addCourseMaterial(file, id);

        return new ResponseEntity<>(courseMaterialList, HttpStatus.CREATED);

    }


    @GetMapping("/{id}")
    public ResponseEntity<List<CourseMaterialDto>> ShowCourseMaterial(@PathVariable Integer id) {
        List<CourseMaterialDto> courseMaterial = courseMaterialService.getCourseMaterial(id);

        return new ResponseEntity<>(courseMaterial, HttpStatus.OK);

    }



    @DeleteMapping("/{id}")
    public ResponseEntity<CourseMaterialResponseDto> DeleteCourseMaterial(@PathVariable Integer id) {
        CourseMaterialResponseDto deleteCourseMaterial = courseMaterialService.CourseMaterialDelete(id);

        return new ResponseEntity<>(deleteCourseMaterial, HttpStatus.OK);
    }



}
