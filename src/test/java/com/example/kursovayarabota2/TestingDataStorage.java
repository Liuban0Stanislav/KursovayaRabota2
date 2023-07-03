package com.example.kursovayarabota2;

import java.util.*;

public class TestingDataStorage {
    public static final Question QUESTION1_JAVA = new Question("тестовый javaВопрос1", "тестовый javaОтвет1");
    public static final Question QUESTION2_JAVA = new Question("тестовый javaВопрос2", "тестовый javaОтвет2");
    public static final Question QUESTION3_JAVA = new Question("тестовый javaВопрос3", "тестовый javaОтвет3");
    public static final Question QUESTION4_JAVA = new Question("тестовый javaВопрос4", "тестовый javaОтвет4");
    public static final Question QUESTION5_JAVA = new Question("тестовый javaВопрос5", "тестовый javaОтвет5");

    public static final Question QUESTION1_MATH = new Question("тестовый mathВопрос1", "тестовый mathОтвет1");
    public static final Question QUESTION2_MATH = new Question("тестовый mathВопрос2", "тестовый mathОтвет2");
    public static final Question QUESTION3_MATH = new Question("тестовый mathВопрос3", "тестовый mathОтвет3");
    public static final Question QUESTION4_MATH = new Question("тестовый mathВопрос4", "тестовый mathОтвет4");
    public static final Question QUESTION5_MATH = new Question("тестовый mathВопрос5", "тестовый mathОтвет5");
    public static Set EMPTY_SET = new HashSet<>();

    public static final Set FULL_JAVA_SET = new HashSet<>(Set.of(
            new Question(QUESTION1_JAVA.getQuestion(), QUESTION1_JAVA.getAnswer()),
            new Question(QUESTION2_JAVA.getQuestion(), QUESTION2_JAVA.getAnswer()),
            new Question(QUESTION3_JAVA.getQuestion(), QUESTION3_JAVA.getAnswer()),
            new Question(QUESTION4_JAVA.getQuestion(), QUESTION4_JAVA.getAnswer()),
            new Question(QUESTION5_JAVA.getQuestion(), QUESTION5_JAVA.getAnswer())
    ));

    public static final Set FULL_MATH_SET = new HashSet<>(Set.of(
            new Question(QUESTION1_MATH.getQuestion(), QUESTION1_MATH.getAnswer()),
            new Question(QUESTION2_MATH.getQuestion(), QUESTION2_MATH.getAnswer()),
            new Question(QUESTION3_MATH.getQuestion(), QUESTION3_MATH.getAnswer()),
            new Question(QUESTION4_MATH.getQuestion(), QUESTION4_MATH.getAnswer()),
            new Question(QUESTION5_MATH.getQuestion(), QUESTION5_MATH.getAnswer())
    ));

    public static final Set FULL_TOTAL_SET = new HashSet<>(Set.of(
            new Question(QUESTION1_JAVA.getQuestion(), QUESTION1_JAVA.getAnswer()),
            new Question(QUESTION2_JAVA.getQuestion(), QUESTION2_JAVA.getAnswer()),
            new Question(QUESTION3_JAVA.getQuestion(), QUESTION3_JAVA.getAnswer()),
            new Question(QUESTION4_JAVA.getQuestion(), QUESTION4_JAVA.getAnswer()),
            new Question(QUESTION5_JAVA.getQuestion(), QUESTION5_JAVA.getAnswer()),
            new Question(QUESTION1_MATH.getQuestion(), QUESTION1_MATH.getAnswer()),
            new Question(QUESTION2_MATH.getQuestion(), QUESTION2_MATH.getAnswer()),
            new Question(QUESTION3_MATH.getQuestion(), QUESTION3_MATH.getAnswer()),
            new Question(QUESTION4_MATH.getQuestion(), QUESTION4_MATH.getAnswer()),
            new Question(QUESTION5_MATH.getQuestion(), QUESTION5_MATH.getAnswer())
    ));

    public static final List<Question> FULL_TOTAL_LIST = new ArrayList<>(FULL_TOTAL_SET);

}

