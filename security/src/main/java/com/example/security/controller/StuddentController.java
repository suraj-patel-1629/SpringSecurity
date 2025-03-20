package com.example.security.controller;

import com.example.security.model.Students;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StuddentController {
    List<Students> stu = new ArrayList<>(List.of(
            new Students("Suraj",87,1),
            new Students("Sejal",98,2)
    ));
    @GetMapping("/students")
    public List<Students> getStudents(){
        return stu;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken)request.getAttribute("_csrf");

    }
    @PostMapping("/students")
    public Students addStudent(@RequestBody Students student){
     stu.add(student);
     return student;
    }

}
