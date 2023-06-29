package com.example.kursovayarabota2.controllers;

import com.example.kursovayarabota2.interfaces.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public String getQuestions(@PathVariable("amount") int amount){
        return "<h1>" + examinerService.getQuestions(amount) + "</h1>";
    }

    @GetMapping("/")
    public String lol(){
        return "hello";
    }
}

