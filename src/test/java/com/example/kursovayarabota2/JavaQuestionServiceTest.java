package com.example.kursovayarabota2;

import com.example.kursovayarabota2.exceptions.NullCollectionException;
import com.example.kursovayarabota2.exceptions.ParameterIsNullException;
import com.example.kursovayarabota2.interfaces.QuestionRepository;
import com.example.kursovayarabota2.repositories.JavaQuestionRepository;
import com.example.kursovayarabota2.services.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static com.example.kursovayarabota2.TestingDataStorage.*;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.client.ExpectedCount.times;


public class JavaQuestionServiceTest {
    @Mock
    private QuestionRepository javaQuestionRepository;
    private JavaQuestionService javaQuestionService;




    @BeforeEach
    public void setUp() {
        javaQuestionService = new JavaQuestionService(javaQuestionRepository);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void addTest (){
        Question expected = new Question(QUESTION4_JAVA.getQuestion(), QUESTION4_JAVA.getAnswer());
        Question actual = javaQuestionService.add(QUESTION4_JAVA.getQuestion(), QUESTION4_JAVA.getAnswer());

        assertEquals(expected, actual);
    }
    @Test
    public void removeTest (){
        Question expected = new Question(QUESTION4_JAVA.getQuestion(), QUESTION4_JAVA.getAnswer());
        Question actual = javaQuestionService.remove(QUESTION4_JAVA.getQuestion(), QUESTION4_JAVA.getAnswer());

        assertEquals(expected, actual);
    }

    @Test
    public void removeNegativeTest() {
        assertThrows(ParameterIsNullException.class, () -> javaQuestionService.remove("", ""));
        assertThrows(ParameterIsNullException.class, () -> javaQuestionService.remove(" ", " "));
    }

    @Test
    public void getAllTest(){
        javaQuestionService.getAll().clear();
        javaQuestionService.getAll().add(QUESTION1_JAVA);
        javaQuestionService.getAll().add(QUESTION2_MATH);
        javaQuestionService.getAll().add(QUESTION3_JAVA);
        javaQuestionService.getAll().add(QUESTION4_JAVA);
        javaQuestionService.getAll().add(QUESTION5_JAVA);
;
        Set<Question> expectedSet = javaQuestionService.getAll();

        assertTrue(expectedSet.containsAll(javaQuestionService.getAll()));
    }
}
