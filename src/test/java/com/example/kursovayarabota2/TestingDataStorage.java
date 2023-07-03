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
    public static Set<Question> EMPTY_SET = new HashSet<>();

    public static final Set<Question> FULL_JAVA_SET = new HashSet<>(Set.of(
            QUESTION1_JAVA,
            QUESTION2_JAVA,
            QUESTION3_JAVA,
            QUESTION4_JAVA,
            QUESTION5_JAVA
    ));

    public static final Set<Question> FULL_MATH_SET = new HashSet<>(Set.of(
            QUESTION1_MATH,
            QUESTION2_MATH,
            QUESTION3_MATH,
            QUESTION4_MATH,
            QUESTION5_MATH
    ));

    public static final Set<Question> FULL_TOTAL_SET = new HashSet<>(Set.of(
            QUESTION1_JAVA,
            QUESTION2_JAVA,
            QUESTION3_JAVA,
            QUESTION4_JAVA,
            QUESTION5_JAVA,
            QUESTION1_MATH,
            QUESTION2_MATH,
            QUESTION3_MATH,
            QUESTION4_MATH,
            QUESTION5_MATH
    ));

    public static final List<Question> FULL_TOTAL_LIST = new ArrayList<>(FULL_TOTAL_SET);

}

