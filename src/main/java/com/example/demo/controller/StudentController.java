package com.example.demo.controller;

import com.example.demo.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    List<Student> student = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "Kali", "Cs"),
                    new Student(2, "Kumar", "IT")
            )
    );

    @GetMapping("/csrf-token")
    public CsrfToken getCsrf(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/")
    @PreAuthorize("hasAuthority('USER_READ')")
    public List<Student> Get(HttpServletRequest request){
        return student;
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    @PostAuthorize("returnObject.name == authentication.name")
    public Student Post(@RequestBody Student student1){
        student.add(student1);
        return student1;
    }
}
