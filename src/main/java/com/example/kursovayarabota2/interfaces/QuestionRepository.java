package com.example.kursovayarabota2.interfaces;

import com.example.kursovayarabota2.Question;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface QuestionRepository {
    Question add(String question, String answer);

    Question remove(String question, String answer);

    Set<Question> getAll();
}
