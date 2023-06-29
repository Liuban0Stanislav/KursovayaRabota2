package com.example.kursovayarabota2;

import com.example.kursovayarabota2.exceptions.AmountOutOfCollectionBoundException;
import com.example.kursovayarabota2.repositories.JavaQuestionRepository;
import com.example.kursovayarabota2.services.ExaminerServiceImpl;
import com.example.kursovayarabota2.services.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.mockito.Mock;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static com.example.kursovayarabota2.TestingDataStorage.*;
import static org.junit.jupiter.api.Assertions.*;


public class ExaminerServiceImplTest {
    private ExaminerServiceImpl examinerService;
    private JavaQuestionRepository javaQuestionRepository;
    @Mock
    private JavaQuestionService javaQuestionService;

    @BeforeEach
    public void setUp() {
        javaQuestionRepository = new JavaQuestionRepository();
        javaQuestionService = new JavaQuestionService(javaQuestionRepository);
//        examinerService = new ExaminerServiceImpl(javaQuestionService);

    }

    public static Stream<Arguments> provideParamsForTheTests() {
        return Stream.of(
                Arguments.of(QUESTION1),
                Arguments.of(QUESTION2),
                Arguments.of(QUESTION3),
                Arguments.of(QUESTION4),
                Arguments.of(QUESTION5)
        );
    }

    /**
     * @Проверка№1: совпадают ли возвращаемый методом вопросы, с вопросами из общего списка?
     *
     * @Результат работы тестируемого метода сохраняем в лист expectedQuestionList
     * @Конструкция из вложенных циклов (см.ниже) и условия внешним циклом пробегает
     * по expectedQuestionList, списку куда сохранились результаты работы тестируемого
     * метода.
     * @Внутренний цикл проходит по сету со всеми вопросами.
     * @Условие внутри циклов проверяет, совпадают ли вопросы из списка полученного
     * из тестируемого метода с вопросами из общего сета.
     * @Если совпадение найдено, то вопрос из expectedQuestionList подставляется в
     * assertEquals как фактический, а вопрос из общего списка как ожидаемый.
     * @Проверка№2: являются ли вопросы, полученные из метода, уникальными.
     * @Создаем Set expectedQuestionSet и в конструктор добавляем лист с вопросами.
     * Set исключает добавление повторяющихся вопросов. Далее сравниваем размер сета
     * и листа. Если они совпадают значит повторяющихся вопросов не было.*/
    @Test
    public void getQuestionsTest() {
        System.out.println(javaQuestionRepository.getAll().size());
        List<String> expectedQuestionList = examinerService.getQuestions(4);

        for (int i = 0; i < expectedQuestionList.size(); i++) {
            for (Question element : javaQuestionRepository.getAll()) {
                if (expectedQuestionList.get(i).equals(element.getQuestion())) {
                    String expectedQuestion = element.getQuestion();
                    String actualQuestion = expectedQuestionList.get(i);
                    assertEquals(expectedQuestion, actualQuestion);
                }
            }
        }
        Set<String> expectedQuestionSet = new HashSet<>(expectedQuestionList);
        assertEquals(expectedQuestionList.size(), expectedQuestionSet.size());
    }

    @Test
    public void getQuestionsExceptionTest() {
        assertThrows(AmountOutOfCollectionBoundException.class,
                () -> examinerService.getQuestions(javaQuestionRepository.getAll().size() + 1));

        assertThrows(AmountOutOfCollectionBoundException.class,
                () -> examinerService.getQuestions(-1));
    }

}
