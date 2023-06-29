package com.example.kursovayarabota2.services;

import com.example.kursovayarabota2.exceptions.NullCollectionException;
import com.example.kursovayarabota2.Question;
import com.example.kursovayarabota2.exceptions.ParameterIsNullException;
import com.example.kursovayarabota2.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Qualifier("JavaQuestionService")
public class JavaQuestionService implements QuestionService {

    private Set<Question> questions = new HashSet<>(Set.of(
            new Question("вопрос 1", "ответ 1"),
            new Question("вопрос 2", "ответ 2"),
            new Question("вопрос 3", "ответ 3"),
            new Question("вопрос 4", "ответ 4"),
            new Question("вопрос 5", "ответ 5"),
            new Question("вопрос 6", "ответ 6")
    ));


    @Override
    public void add(String question, String answer) {
        validateParameter(question);
        validateParameter(answer);
        questions.add(new Question(question, answer));
        System.out.println("объект Question добавлен\n" +
                question + "\n" +
                answer + "\n");
    }

    @Override
    public void remove(String question, String answer) {
        validateParameter(question);
        validateParameter(answer);
        Question questionNeedRemove = new Question(question, answer);
        questions.remove(questionNeedRemove);
        System.out.println("объект Question удален\n" +
                question + "\n" +
                answer + "\n");
    }

    @Override
    public Set<Question> getAll() {
        for(Question question: questions){
            System.out.println(question);
        }
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        validateCollectionIsNotNull();
        int size = questions.size();
        int item = new Random().nextInt(size);
        int i = 0;
        Question rez = null;
        for (Question element : questions) {
            if (i == item) {
                rez = element;
            }
            i++;
        }
        return rez;
    }

    private void validateCollectionIsNotNull() {
        if (questions.isEmpty()) {
            throw new NullCollectionException("коллекция пуста");
        }
    }

    private void validateParameter(String parameter){
        if(parameter.equals("")){
            throw new ParameterIsNullException("пользователь забыл ввести вопрос либо ответ");
        }
    }
}

