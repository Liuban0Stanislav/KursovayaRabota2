package com.example.kursovayarabota2.repositories;

import com.example.kursovayarabota2.Question;
import com.example.kursovayarabota2.exceptions.NullCollectionException;
import com.example.kursovayarabota2.exceptions.ParameterIsNullException;
import com.example.kursovayarabota2.interfaces.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
@Qualifier("javaQuestionRepository")
public class JavaQuestionRepository implements QuestionRepository {

    private Set<Question> questions = new HashSet<>();

    @PostConstruct
    public void init() {
        questions.add(new Question("javaВопрос 1", "javaОтвет 1"));
        questions.add(new Question("javaВопрос 2", "javaОтвет 2"));
        questions.add(new Question("javaВопрос 3", "javaОтвет 3"));
        questions.add(new Question("javaВопрос 4", "javaОтвет 4"));
        questions.add(new Question("javaВопрос 5", "javaОтвет 5"));
        questions.add(new Question("javaВопрос 6", "javaОтвет 6"));
    }

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
        for (Question question : questions) {
        }
        return questions;
    }


    private void validateParameter(String parameter) {
        if (parameter.equals("")) {
            throw new ParameterIsNullException("пользователь забыл ввести вопрос либо ответ");
        }
    }
}
