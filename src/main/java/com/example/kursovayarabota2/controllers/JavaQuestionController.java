package com.example.kursovayarabota2.controllers;

import com.example.kursovayarabota2.interfaces.ExaminerService;
import com.example.kursovayarabota2.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private QuestionService questionService;
    private ExaminerService examinerService;

    public JavaQuestionController(@Qualifier("JavaQuestionService") QuestionService questionService,
                                  ExaminerService examinerService) {
        this.questionService = questionService;
        this.examinerService = examinerService;
    }

    @GetMapping("/lol")
    public String lol(){
        return "Lol";
    }

    @GetMapping("/")
    public String getAll() {
        return questionService.getAll().toString();
    }

    @GetMapping("/add")
    public String add(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        questionService.add(question, answer);
        return "объект Question добавлен\n" +
                question + "\n" +
                answer + "\n";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        questionService.remove(question, answer);
        return "объект Question удален\n" +
                question + "\n" +
                answer + "\n";
    }

    @GetMapping("/get/question/{amount}")
    public String getQuestion(@PathVariable("amount") int amount) {
        return "<h1>Случайный вопрос: \n</h1>" +
                examinerService.getQuestions(amount);
    }
}

