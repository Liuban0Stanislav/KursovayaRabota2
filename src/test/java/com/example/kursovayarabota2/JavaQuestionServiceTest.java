package com.example.kursovayarabota2;

import com.example.kursovayarabota2.exceptions.NullCollectionException;
import com.example.kursovayarabota2.model.Question;
import com.example.kursovayarabota2.repositories.JavaQuestionRepository;
import com.example.kursovayarabota2.services.JavaQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static com.example.kursovayarabota2.TestingDataStorage.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    @Mock
    private JavaQuestionRepository javaQuestionRepository;
    @InjectMocks
    private JavaQuestionService javaQuestionService;

    @Test
    public void addTest (){
        Question expected = new Question(QUESTION1_JAVA.getQuestion(), QUESTION1_JAVA.getAnswer());
        Mockito.when(javaQuestionRepository.add(any(), any())).thenReturn(expected);
        Question actual = javaQuestionService.add(QUESTION1_JAVA.getQuestion(), QUESTION1_JAVA.getAnswer());

        assertEquals(expected, actual);
    }
    @Test
    public void removeTest (){
        Question expected = new Question(QUESTION4_JAVA.getQuestion(), QUESTION4_JAVA.getAnswer());
        Mockito.when(javaQuestionRepository.remove(any(), any())).thenReturn(expected);
        Question actual = javaQuestionService.remove(QUESTION4_JAVA.getQuestion(), QUESTION4_JAVA.getAnswer());

        assertEquals(expected, actual);
    }

    @Test
    public void getAllTest(){

        javaQuestionService.getAll().clear();
        javaQuestionService.getAll().add(QUESTION1_JAVA);
        javaQuestionService.getAll().add(QUESTION2_MATH);
        javaQuestionService.getAll().add(QUESTION3_JAVA);
        javaQuestionService.getAll().add(QUESTION4_JAVA);
        javaQuestionService.getAll().add(QUESTION5_JAVA);
        Set<Question> expectedSet = javaQuestionService.getAll();

        assertTrue(expectedSet.containsAll(javaQuestionService.getAll()));
    }

    @Test
    public void getRandomQuestionTest() {
        Mockito.when(javaQuestionRepository.getAll()).thenReturn(FULL_JAVA_SET);
        assertTrue(FULL_JAVA_SET.contains(javaQuestionService.getRandomQuestion()));
    }

    @Test
    public void getRandomQuestionExceptionTest(){
        Mockito.when(javaQuestionRepository.getAll()).thenReturn(EMPTY_SET);
        assertThrows(NullCollectionException.class, () -> javaQuestionService.getRandomQuestion());
    }
}
