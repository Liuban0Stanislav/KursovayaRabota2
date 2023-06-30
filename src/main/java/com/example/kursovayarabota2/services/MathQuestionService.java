package com.example.kursovayarabota2.services;

import com.example.kursovayarabota2.Question;
import com.example.kursovayarabota2.exceptions.NullCollectionException;
import com.example.kursovayarabota2.interfaces.QuestionRepository;
import com.example.kursovayarabota2.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.Set;

@Service
@Qualifier("mathQuestionService")
public class MathQuestionService implements QuestionService {

    QuestionRepository mathQuestionRepository;

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
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
