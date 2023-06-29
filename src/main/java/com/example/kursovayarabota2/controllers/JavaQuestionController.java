package com.example.kursovayarabota2.controllers;

import com.example.kursovayarabota2.interfaces.ExaminerService;
import com.example.kursovayarabota2.interfaces.QuestionRepository;
import com.example.kursovayarabota2.interfaces.QuestionService;
import com.example.kursovayarabota2.repositories.JavaQuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private QuestionService questionService;
    private ExaminerService examinerService;
    private QuestionRepository questionRepository;

    public JavaQuestionController(@Qualifier("javaQuestionService") QuestionService questionService,
                                  ExaminerService examinerService,
                                  @Qualifier("javaQuestionRepository") QuestionRepository questionRepository) {
        this.questionService = questionService;
        this.examinerService = examinerService;
        this.questionRepository = questionRepository;
    }

    @GetMapping("/")
    public String getAll() {
        return questionRepository.getAll().toString();
    }

    @GetMapping("/add")
    public String add(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        questionRepository.add(question, answer);
        return "объект Question добавлен\n" +
                question + "\n" +
                answer + "\n";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        questionRepository.remove(question, answer);
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

