package com.example.kursovayarabota2.interfaces;

import com.example.kursovayarabota2.Question;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface QuestionRepository {
    void add(String question, String answer);

    void remove(String question, String answer);

    Set<Question> getAll();
}
