package com.example.BegineerMongoDB;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

    @Autowired //Autowiring feature of spring framework enables you to inject the object dependency implicitly. It internally uses setter or constructor injection.
    // Autowiring can't be used to inject primitive and string values. It works with reference only.
    private final StudentService studentService;

    @GetMapping
    public List<Student> fetchAllStudents(){
        return studentService.getAllStudents();
    }
}
