package com.example.kursovayarabota2;

import com.example.kursovayarabota2.exceptions.AmountOutOfCollectionBoundException;
import com.example.kursovayarabota2.interfaces.QuestionRepository;
import com.example.kursovayarabota2.interfaces.QuestionService;
import com.example.kursovayarabota2.repositories.JavaQuestionRepository;
import com.example.kursovayarabota2.repositories.MathQuestionRepository;
import com.example.kursovayarabota2.services.ExaminerServiceImpl;
import com.example.kursovayarabota2.services.JavaQuestionService;
import com.example.kursovayarabota2.services.MathQuestionService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.*;

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
        examinerService = new ExaminerServiceImpl(javaQuestionService, mathQuestionService,
                                                javaQuestionRepository, mathQuestionRepository);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getQuestionsTest() {
        Mockito.when(javaQuestionService.getAll()).thenReturn(FULL_JAVA_SET);
        Mockito.when(mathQuestionService.getAll()).thenReturn(FULL_MATH_SET);

        Mockito.when(javaQuestionService.getRandomQuestion())
                .thenReturn(QUESTION1_JAVA)
                .thenReturn(QUESTION2_JAVA)
                .thenReturn(QUESTION3_JAVA)
                .thenReturn(QUESTION4_JAVA)
                .thenReturn(QUESTION5_JAVA);

        Mockito.when(mathQuestionService.getRandomQuestion())
                .thenReturn(QUESTION1_MATH)
                .thenReturn(QUESTION2_MATH)
                .thenReturn(QUESTION3_MATH)
                .thenReturn(QUESTION4_MATH)
                .thenReturn(QUESTION5_MATH);

        assertTrue(FULL_TOTAL_SET.containsAll(examinerService.getQuestions(2)));
    }

//    @Test
//    public void getQuestionsExceptionTest() {
//        assertThrows(AmountOutOfCollectionBoundException.class,
//                () -> examinerService.getQuestions(javaQuestionRepository.getAll().size() + 1));
//
//        assertThrows(AmountOutOfCollectionBoundException.class,
//                () -> examinerService.getQuestions(-1));
//    }

}
