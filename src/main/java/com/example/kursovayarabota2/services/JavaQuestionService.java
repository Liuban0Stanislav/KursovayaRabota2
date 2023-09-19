package com.example.kursovayarabota2.services;

import com.example.kursovayarabota2.exceptions.NullCollectionException;
import com.example.kursovayarabota2.model.Question;
import com.example.kursovayarabota2.interfaces.QuestionRepository;
import com.example.kursovayarabota2.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Component
@Qualifier("javaQuestionService")
public class JavaQuestionService implements QuestionService {
   private QuestionRepository javaQuestionRepository;
   @Autowired
    public JavaQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return javaQuestionRepository.add(question, answer);
    }

    @Override
    public Question remove(String question, String answer) {
        return javaQuestionRepository.remove(question, answer);
    }

    @Override
    public Set<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        validateCollectionIsNotNull();
        int size = javaQuestionRepository.getAll().size();
        int item = new Random().nextInt(size);
        int i = 0;
        Question rez = null;
        for (Question element : javaQuestionRepository.getAll()) {
            if (i == item) {
                rez = element;
                break;
            }
            i++;
        }
        return rez;
    }

    private void validateCollectionIsNotNull() {
        if (javaQuestionRepository.getAll().isEmpty()) {
            throw new NullCollectionException("коллекция пуста");
        }
    }
}

