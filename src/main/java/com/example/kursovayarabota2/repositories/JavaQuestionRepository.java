package com.example.kursovayarabota2.repositories;

import com.example.kursovayarabota2.Question;
import com.example.kursovayarabota2.interfaces.QuestionRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public class JavaQuestionRepository implements QuestionRepository {
    @Override
    public void add(String question, String answer) {

    }

    @Override
    public void remove(String question, String answer) {

    }

    @Override
    public Set<Question> getAll() {
        return null;
    }
}
