package com.example.kursovayarabota2.controllers;

import com.example.kursovayarabota2.interfaces.ExaminerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam")
public class ExamController {
    ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public String getQuestions(@PathVariable("amount") int amount){
        return "<h1>" + examinerService.getQuestions(amount) + "</h1>";
    }
}

