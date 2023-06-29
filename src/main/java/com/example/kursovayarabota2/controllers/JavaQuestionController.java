package com.example.kursovayarabota2.controllers;

import com.example.kursovayarabota2.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private QuestionService questionService;
    public JavaQuestionController(@Qualifier("JavaQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/")
    public String getAll(){
        return questionService.getAll().toString();
    }

    @GetMapping("/add")
    public String add(@RequestParam("question")String question, @RequestParam("answer")String answer){
        questionService.add(question, answer);
        return "объект Question добавлен\n" +
                question + "\n" +
                answer + "\n";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("question")String question, @RequestParam("answer")String answer){
        questionService.remove(question, answer);
        return "объект Question удален\n" +
                question + "\n" +
                answer + "\n";
    }
}
