package com.example.kursovayarabota2.controllers;

import com.example.kursovayarabota2.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {
    QuestionService questionService;

    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/")
    public String getAll(){
        return questionService.getAll().toString();
    }

    @PostMapping("/add")
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
