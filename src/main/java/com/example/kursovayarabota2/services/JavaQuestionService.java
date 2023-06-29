package com.example.kursovayarabota2.services;

import com.example.kursovayarabota2.exceptions.NullCollectionException;
import com.example.kursovayarabota2.Question;
import com.example.kursovayarabota2.exceptions.ParameterIsNullException;
import com.example.kursovayarabota2.interfaces.QuestionRepository;
import com.example.kursovayarabota2.interfaces.QuestionService;
import com.example.kursovayarabota2.repositories.JavaQuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Qualifier("javaQuestionService")
public class JavaQuestionService implements QuestionService {

   private QuestionRepository questionRepository;

    public JavaQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question getRandomQuestion() {
        validateCollectionIsNotNull();
        int size = questionRepository.getAll().size();
        int item = new Random().nextInt(size);
        int i = 0;
        Question rez = null;
        for (Question element : questionRepository.getAll()) {
            if (i == item) {
                rez = element;
            }
            i++;
        }
        return rez;
    }

    private void validateCollectionIsNotNull() {
        if (questionRepository.getAll().isEmpty()) {
            throw new NullCollectionException("коллекция пуста");
        }
    }
}

