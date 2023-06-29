package com.example.kursovayarabota2.controllers;

import com.example.kursovayarabota2.interfaces.QuestionRepository;
import com.example.kursovayarabota2.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {
    QuestionService questionService;
    QuestionRepository questionRepository;

    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService questionService,
                                  @Qualifier("mathQuestionRepository")QuestionRepository questionRepository) {
        this.questionService = questionService;
        this.questionRepository = questionRepository;
    }

    @GetMapping("/")
    public String getAll(){
        return questionRepository.getAll().toString();
    }

    @GetMapping("/add")
    public String add(@RequestParam("question")String question, @RequestParam("answer")String answer){
        questionRepository.add(question, answer);
        return "объект Question добавлен\n" +
                question + "\n" +
                answer + "\n";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("question")String question, @RequestParam("answer")String answer){
        questionRepository.remove(question, answer);
        return "объект Question удален\n" +
                question + "\n" +
                answer + "\n";
    }
}
