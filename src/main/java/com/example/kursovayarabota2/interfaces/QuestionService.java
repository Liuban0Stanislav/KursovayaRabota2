package com.example.kursovayarabota2.interfaces;

import com.example.kursovayarabota2.model.Question;

import java.util.Set;

public interface QuestionService {
    Question add(String question, String answer);

    Question remove(String question, String answer);

    Set<Question> getAll();
    Question getRandomQuestion();
}
