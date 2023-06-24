package com.example.kursovayarabota2;

import com.example.kursovayarabota2.interfaces.ExaminerService;
import com.example.kursovayarabota2.interfaces.QuestionService;
import com.example.kursovayarabota2.services.ExaminerServiceImpl;
import com.example.kursovayarabota2.services.JavaQuestionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.kursovayarabota2.services.ExaminerServiceImpl;

@SpringBootApplication
public class KursovayaRabota2Application {

    public static void main(String[] args) {
        SpringApplication.run(KursovayaRabota2Application.class, args);

    }

}
