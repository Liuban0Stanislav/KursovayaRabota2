package com.example.kursovayarabota2;

import com.example.kursovayarabota2.exceptions.NullCollectionException;
import com.example.kursovayarabota2.exceptions.ParameterIsNullException;
import com.example.kursovayarabota2.repositories.JavaQuestionRepository;
import com.example.kursovayarabota2.services.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

import static com.example.kursovayarabota2.TestingDataStorage.EMPTY_SET;
import static com.example.kursovayarabota2.TestingDataStorage.FULL_SET;
import static org.junit.jupiter.api.Assertions.*;


public class JavaQuestionServiceTest {
    @Mock
    private JavaQuestionRepository javaQuestionRepository;
    private JavaQuestionService jqs;


    @BeforeEach
    public void setUp() {
        javaQuestionRepository = new JavaQuestionRepository();
        jqs = new JavaQuestionService(javaQuestionRepository);
    }

    @Test
    public void CollectionISNotNullExceptionTest(){
        Set<Question> set = new HashSet<>();
        Mockito.when(javaQuestionRepository.getAll()).thenReturn(set);

        assertThrows(NullCollectionException.class, ()-> jqs.getRandomQuestion());
    }
}
