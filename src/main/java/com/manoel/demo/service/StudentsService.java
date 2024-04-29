package com.manoel.demo.service;

import com.manoel.demo.entity.StudentEntity;
import com.manoel.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {

    @Autowired
    private StudentRepository studentRepository;

    public String saveStudent(StudentEntity parametro){
        studentRepository.save(parametro);
        return "salvo com sucesso";
    }

    public List<StudentEntity> getStudents(){
        return studentRepository.findAll();
    }

}
