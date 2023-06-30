package com.example.kursovayarabota2;

import com.example.kursovayarabota2.exceptions.ParameterIsNullException;
import com.example.kursovayarabota2.repositories.JavaQuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static com.example.kursovayarabota2.TestingDataStorage.*;
import static com.example.kursovayarabota2.TestingDataStorage.QUESTION5;
import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionRepositoryTest {

    private JavaQuestionRepository javaQuestionRepository;

    @BeforeEach
    public void setUp() {
        javaQuestionRepository = new JavaQuestionRepository();
        javaQuestionRepository.getAll().clear(); //очищаю коллекцию
        assertTrue(javaQuestionRepository.getAll().isEmpty()); //проверка, что коллекция пуста
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

    private void fullCollectionWithTestQuestions() {
        javaQuestionRepository.getAll().add(QUESTION1);
        javaQuestionRepository.getAll().add(QUESTION2);
        javaQuestionRepository.getAll().add(QUESTION3);
        javaQuestionRepository.getAll().add(QUESTION4);
        javaQuestionRepository.getAll().add(QUESTION5);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTheTests")
    public void addParametrisedTest(Question question) {
        fullCollectionWithTestQuestions();//добавляю тестовые вопросы и ответы

        assertTrue(javaQuestionRepository.getAll().contains(question)); //проверяю что тестовые вопросы добавились в коллекцию
    }

    @Test
    public void addTest() {
        fullCollectionWithTestQuestions();//добавляю тестовые вопросы и ответы

        assertTrue(javaQuestionRepository.getAll().contains(QUESTION1)); //проверяю что тестовые вопросы добавились в коллекцию
        assertTrue(javaQuestionRepository.getAll().contains(QUESTION2)); //проверяю что тестовые вопросы добавились в коллекцию
        assertTrue(javaQuestionRepository.getAll().contains(QUESTION3)); //проверяю что тестовые вопросы добавились в коллекцию
        assertTrue(javaQuestionRepository.getAll().contains(QUESTION4)); //проверяю что тестовые вопросы добавились в коллекцию
        assertTrue(javaQuestionRepository.getAll().contains(QUESTION5)); //проверяю что тестовые вопросы добавились в коллекцию
    }

    @Test
    public void removeTest() {
        String question1 = QUESTION1.getQuestion();
        String answer1 = QUESTION1.getAnswer();

        javaQuestionRepository.add(question1, answer1);//добавляю тестовые вопросы и ответы
        assertTrue(javaQuestionRepository.getAll().contains(QUESTION1)); //проверяю что тестовый вопрос добавился в коллекцию

        javaQuestionRepository.remove(QUESTION1.getQuestion(), QUESTION1.getAnswer());//удаляю вопрос из коллекции
        assertFalse(javaQuestionRepository.getAll().contains(QUESTION1)); //проверяю что тестовый вопрос удалился из коллекции
    }

    @Test
    public void getAllTest() {
        fullCollectionWithTestQuestions();//добавляю тестовые вопросы и ответы

        Set<Question> expectedSet = new HashSet<>(); //заполняю "ожидаемую" коллекцию
        expectedSet.add(new Question(QUESTION1.getQuestion(), QUESTION1.getAnswer()));
        expectedSet.add(new Question(QUESTION2.getQuestion(), QUESTION2.getAnswer()));
        expectedSet.add(new Question(QUESTION3.getQuestion(), QUESTION3.getAnswer()));
        expectedSet.add(new Question(QUESTION4.getQuestion(), QUESTION4.getAnswer()));
        expectedSet.add(new Question(QUESTION5.getQuestion(), QUESTION5.getAnswer()));

        assertNotNull(javaQuestionRepository.getAll()); //проверка, что коллекция не пуста
        assertEquals(expectedSet, javaQuestionRepository.getAll()); //проверка, что ожидаемая и актуальные коллекции совпадают
    }

    @Test
    public void addValidateParameterTest() {
        assertThrows(ParameterIsNullException.class, () -> javaQuestionRepository.add("", ""));
    }

    @Test
    public void getRandomQuestionTest() {
        assertThrows(ParameterIsNullException.class, () -> javaQuestionRepository.add("", ""));
    }

    @Test
    public void initTest() {
        javaQuestionRepository.init();
        Set<Question> questionsExpected = new HashSet<>(Set.of(
                new Question("javaВопрос 1", "javaОтвет 1"),
                new Question("javaВопрос 2", "javaОтвет 2"),
                new Question("javaВопрос 3", "javaОтвет 3"),
                new Question("javaВопрос 4", "javaОтвет 4"),
                new Question("javaВопрос 5", "javaОтвет 5"),
                new Question("javaВопрос 6", "javaОтвет 6")
        ));
        assertTrue(javaQuestionRepository.getAll().containsAll(questionsExpected));
    }

}
