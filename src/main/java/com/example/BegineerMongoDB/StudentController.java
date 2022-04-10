package com.example.BegineerMongoDB;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

   @GetMapping
    public @ResponseBody List<Student> fetchAllStudents(){
        return studentService.getAllStudents();
    }
}
