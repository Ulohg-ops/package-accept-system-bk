package com.example.packagereceivesystem.controller;

import com.example.packagereceivesystem.model.Student;
import com.example.packagereceivesystem.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentDao studentDao;

    @GetMapping("/getAll")
    public List<Student> list(){
        return studentDao.findAllStudent();
    }


    @PostMapping("/add")
    public void add(@RequestBody Student student){
        studentDao.saveStudent(student);
    }

}
