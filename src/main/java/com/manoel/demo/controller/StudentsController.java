package com.manoel.demo.controller;

import com.manoel.demo.entity.StudentEntity;
import com.manoel.demo.entity.dto.StudentDTO;
import com.manoel.demo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping
    public List<StudentEntity> getStudents() {
        return studentsService.getStudents();
    }

    @GetMapping("/{studentId}")
    public StudentDTO getStudentById(@PathVariable(value = "studentId") Long studentId) {
        StudentEntity entity = studentsService.getStudentById(studentId);
        StudentDTO studentDTO = new StudentDTO(entity.getName(), entity.getEmail(), entity.getDataOfBirth());
        return studentDTO;
    }

    @PostMapping
    public String saveStudent(@RequestBody StudentDTO studentDTO) {
        StudentEntity studentEntity = studentDTO.builder(studentDTO.getName(), studentDTO.getEmail(), studentDTO.getDateOfBirth());
        return studentsService.saveStudent(studentEntity);
    }

}
