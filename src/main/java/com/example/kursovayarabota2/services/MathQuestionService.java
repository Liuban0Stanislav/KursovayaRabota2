package com.example.kursovayarabota2.services;

import com.example.kursovayarabota2.model.Question;
import com.example.kursovayarabota2.exceptions.NullCollectionException;
import com.example.kursovayarabota2.interfaces.QuestionRepository;
import com.example.kursovayarabota2.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.Set;

@Service
@Component
@Qualifier("mathQuestionService")
public class MathQuestionService implements QuestionService {
    private QuestionRepository mathQuestionRepository;

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }
    @Override
    public Question add(String question, String answer) {
        return mathQuestionRepository.add(question, answer);
    }

    @Override
    public Question remove(String question, String answer) {
        return mathQuestionRepository.remove(question, answer);
    }

    @Override
    public Set<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        validateCollectionIsNotNull();
        int size = mathQuestionRepository.getAll().size();
        int item = new Random().nextInt(size);
        int i = 0;
        Question rez = null;
        for (Question element : mathQuestionRepository.getAll()) {
            if (i == item) {
                rez = element;
                break;
            }
            i++;
        }
        return rez;
    }

    private void validateCollectionIsNotNull() {
        if (mathQuestionRepository.getAll().isEmpty()) {
            throw new NullCollectionException("коллекция пуста");
        }
    }
}
