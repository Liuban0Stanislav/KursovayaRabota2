package com.example.kursovayarabota2;

import java.util.HashSet;
import java.util.Set;

public class TestingDataStorage {
    public static final Question QUESTION1 = new Question("тестовый вопрос1", "тестовый ответ1");
    public static final Question QUESTION2 = new Question("тестовый вопрос2", "тестовый ответ2");
    public static final Question QUESTION3 = new Question("тестовый вопрос3", "тестовый ответ3");
    public static final Question QUESTION4 = new Question("тестовый вопрос4", "тестовый ответ4");
    public static final Question QUESTION5 = new Question("тестовый вопрос5", "тестовый ответ5");
    public static final Set EMPTY_SET = new HashSet<>();

    public static final Set FULL_SET = new HashSet<>(Set.of(
            new Question(QUESTION1.getQuestion(), QUESTION1.getAnswer()),
            new Question(QUESTION2.getQuestion(), QUESTION2.getAnswer()),
            new Question(QUESTION3.getQuestion(), QUESTION3.getAnswer()),
            new Question(QUESTION4.getQuestion(), QUESTION4.getAnswer()),
            new Question(QUESTION5.getQuestion(), QUESTION5.getAnswer())
    ));


}
