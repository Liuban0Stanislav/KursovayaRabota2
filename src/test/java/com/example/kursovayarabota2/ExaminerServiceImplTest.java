package com.example.kursovayarabota2;

import com.example.kursovayarabota2.services.ExaminerServiceImpl;
import com.example.kursovayarabota2.services.JavaQuestionService;
import com.example.kursovayarabota2.services.MathQuestionService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.kursovayarabota2.TestingDataStorage.*;


@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;
    @Mock
    private MathQuestionService mathQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

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

        System.out.println(examinerService.getQuestions(4));
//        List<String> questions = examinerService.getQuestions(4);
//        assertTrue(FULL_TOTAL_SET.containsAll(questions));
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
