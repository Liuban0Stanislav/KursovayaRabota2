package com.example.kursovayarabota2;

import com.example.kursovayarabota2.exceptions.AmountOutOfCollectionBoundException;
import com.example.kursovayarabota2.interfaces.QuestionRepository;
import com.example.kursovayarabota2.interfaces.QuestionService;
import com.example.kursovayarabota2.repositories.JavaQuestionRepository;
import com.example.kursovayarabota2.repositories.MathQuestionRepository;
import com.example.kursovayarabota2.services.ExaminerServiceImpl;
import com.example.kursovayarabota2.services.JavaQuestionService;
import com.example.kursovayarabota2.services.MathQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Qualifier;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static com.example.kursovayarabota2.TestingDataStorage.*;
import static org.junit.jupiter.api.Assertions.*;


public class ExaminerServiceImplTest {
    private ExaminerServiceImpl examinerService;
    @Mock
    private JavaQuestionService javaQuestionService;
    @Mock
    private MathQuestionService mathQuestionService;
    @Mock
    private JavaQuestionRepository javaQuestionRepository;
    @Mock
    private MathQuestionRepository mathQuestionRepository;

    @BeforeEach
    public void setUp() {
        javaQuestionRepository = new JavaQuestionRepository();
        mathQuestionRepository = new MathQuestionRepository();

        javaQuestionService = new JavaQuestionService(javaQuestionRepository);
        mathQuestionService = new MathQuestionService(mathQuestionRepository);

        examinerService = new ExaminerServiceImpl(javaQuestionService, mathQuestionService);
        MockitoAnnotations.openMocks(this);
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
        Mockito.when(javaQuestionRepository.getAll()).thenReturn(FULL_SET);
        List<String>questionList = examinerService.getQuestions(4);

//        for(String question: questionList){
            assertTrue(FULL_SET.containsAll(questionList));
//        }
    }

//    @Test
//    public void getQuestionsTest() {
//        Mockito.when(javaQuestionRepository.getAll().size()).thenReturn(4);
//        Mockito.when(javaQuestionRepository.getAll()).thenReturn(FULL_SET);
//
//        System.out.println(javaQuestionRepository.getAll().size());
//        List<String> expectedQuestionList = examinerService.getQuestions(4);
//
//        for (int i = 0; i < expectedQuestionList.size(); i++) {
//            for (Question element : javaQuestionRepository.getAll()) {
//                if (expectedQuestionList.get(i).equals(element.getQuestion())) {
//                    String expectedQuestion = element.getQuestion();
//                    String actualQuestion = expectedQuestionList.get(i);
//                    assertEquals(expectedQuestion, actualQuestion);
//                }
//            }
//        }
//        Set<String> expectedQuestionSet = new HashSet<>(expectedQuestionList);
//        assertEquals(expectedQuestionList.size(), expectedQuestionSet.size());
//    }

    @Test
    public void getQuestionsExceptionTest() {
        assertThrows(AmountOutOfCollectionBoundException.class,
                () -> examinerService.getQuestions(javaQuestionRepository.getAll().size() + 1));

        assertThrows(AmountOutOfCollectionBoundException.class,
                () -> examinerService.getQuestions(-1));
    }

}

