package com.example.kursovayarabota2.services;

import com.example.kursovayarabota2.exceptions.AmountOutOfCollectionBoundException;
import com.example.kursovayarabota2.interfaces.ExaminerService;
import com.example.kursovayarabota2.interfaces.QuestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    /**
     * Коллекция questionList предназначена для хранения уникальных вопросов
     */
    private List<String> questionsList = new ArrayList<>();
    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    /**
     * Метод возвращает коллекцию из оригинальных вопросов типа String. Количество вопросов
     * задается как параметр метода.
     *
     * @Цикл длится пока счетчик оригинальных вопросов не будет равен заданному
     * количеству. В теле цикла мы получаем из коллекции случайный вопрос,
     * а затем проверяем его на уникальность (нет ли в листе questionList такого
     * же вопроса). Если вопрос уникален, то добавляем его в лист questionList
     */
    @Override
    public List<String> getQuestions(int amount) {
        questionsList.clear();
        validateQuantityQuestions(amount);
        int originalQuestionsCounter = 1;
        while (originalQuestionsCounter <= amount) {
            String question = questionService.getRandomQuestion().getQuestion();
            if (questionService.equals(question)) {
                questionsList.add(questionService.getRandomQuestion().getQuestion());
                originalQuestionsCounter++;
            }
        }
        return questionsList;
    }

    /**
     * Метод возвращает true, если вопрос уникален или false, если такой вопрос
     * уже присутствует в questionList.
     *
     * @Цикл пробегает по коллекции "вопрос-ответ" и сравнивает вопрос параметр
     * с вопросом полученным из коллекции, если вопросы совпадают, то возвращается
     * false, если совпадений не найдено, то возвращается true
     */
    private boolean isQuestionUnique(String question) {
        for (String element : questionsList) {
            if (element.equals(question)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Метод проверяет не выходит ли введенный параметр amount за пределы размера
     * коллекции Set (вопрос-ответ), находящейся в questionService. И если выходит,
     * то выбрасывается исключение
     */
    private void validateQuantityQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new AmountOutOfCollectionBoundException();
        }
    }
}

