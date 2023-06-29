package com.example.kursovayarabota2.interfaces;

import com.example.kursovayarabota2.Question;

import java.util.Set;

public interface QuestionRepository {

    void add(String question, String answer);

    void remove(String question, String answer);

    Set<Question> getAll();
}
