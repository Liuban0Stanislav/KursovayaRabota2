package com.example.kursovayarabota2.interfaces;

import com.example.kursovayarabota2.Question;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface QuestionService {
    Question add(String question, String answer);

    Question remove(String question, String answer);

    Set<Question> getAll();
    Question getRandomQuestion();
}
