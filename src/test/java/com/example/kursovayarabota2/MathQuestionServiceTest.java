package com.example.kursovayarabota2;

import com.example.kursovayarabota2.exceptions.NullCollectionException;
import com.example.kursovayarabota2.exceptions.ParameterIsNullException;
import com.example.kursovayarabota2.interfaces.QuestionRepository;
import com.example.kursovayarabota2.interfaces.QuestionService;
import com.example.kursovayarabota2.repositories.MathQuestionRepository;
import com.example.kursovayarabota2.services.MathQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Set;

import static com.example.kursovayarabota2.TestingDataStorage.*;

import static org.junit.jupiter.api.Assertions.*;


public class MathQuestionServiceTest {
    @Mock
    private QuestionRepository mathQuestionRepository;
    private QuestionService mathQuestionService;


    @BeforeEach
    public void setUp() {
        mathQuestionRepository = new MathQuestionRepository();
        mathQuestionService = new MathQuestionService(mathQuestionRepository);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void addTest (){
        Question expected = new Question(QUESTION4_MATH.getQuestion(), QUESTION4_MATH.getAnswer());
        Question actual = mathQuestionService.add(QUESTION4_MATH.getQuestion(), QUESTION4_MATH.getAnswer());

        assertEquals(expected, actual);
    }
    @Test
    public void removeTest (){
        Question expected = new Question(QUESTION4_MATH.getQuestion(), QUESTION4_MATH.getAnswer());
        Question actual = mathQuestionService.remove(QUESTION4_MATH.getQuestion(), QUESTION4_MATH.getAnswer());

        assertEquals(expected, actual);
    }

    @Test
    public void removeNegativeTest() {
        assertThrows(ParameterIsNullException.class, () -> mathQuestionService.remove("", ""));
        assertThrows(ParameterIsNullException.class, () -> mathQuestionService.remove(" ", " "));
    }

    @Test
    public void getAllTest(){
        mathQuestionService.getAll().clear();
        mathQuestionService.getAll().add(QUESTION1_MATH);
        mathQuestionService.getAll().add(QUESTION2_MATH);
        mathQuestionService.getAll().add(QUESTION3_MATH);
        mathQuestionService.getAll().add(QUESTION4_MATH);
        mathQuestionService.getAll().add(QUESTION5_MATH);
        ;
        Set<Question> expectedSet = mathQuestionService.getAll();

        assertTrue(expectedSet.containsAll(mathQuestionService.getAll()));
    }
    @Test
    public void getRandomQuestionTest(){
        Mockito.when(mathQuestionRepository.getAll()).thenReturn(FULL_MATH_SET);
        assertTrue(FULL_MATH_SET.contains(mathQuestionService.getRandomQuestion()));
    }

    @Test
    public void getRandomQuestionExceptionTest(){
        Mockito.when(mathQuestionRepository.getAll()).thenReturn(EMPTY_SET);
        assertThrows(NullCollectionException.class, () -> mathQuestionService.getRandomQuestion());
    }
}
