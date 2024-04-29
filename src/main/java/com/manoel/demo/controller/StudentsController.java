package com.manoel.demo.controller;

import com.manoel.demo.entity.StudentEntity;
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
    public List<StudentEntity> getStudents(){
        return studentsService.getStudents();
    }

    @PostMapping
    public String saveStudent(@RequestBody String name){
        StudentEntity studentEntity = new StudentEntity(name, LocalDate.now(), "email.odmaodsja");
        studentsService.saveStudent(studentEntity);
        return "teste";
    }

}
