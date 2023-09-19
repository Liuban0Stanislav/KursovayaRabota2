package com.example.kursovayarabota2.repositories;

        import com.example.kursovayarabota2.model.Question;
        import com.example.kursovayarabota2.exceptions.ParameterIsNullException;
        import com.example.kursovayarabota2.interfaces.QuestionRepository;
        import org.springframework.beans.factory.annotation.Qualifier;
        import org.springframework.stereotype.Repository;

        import javax.annotation.PostConstruct;
        import java.util.HashSet;
        import java.util.Set;

@Repository
@Qualifier("mathQuestionRepository")
public class MathQuestionRepository implements QuestionRepository {

    private Set<Question> questions = new HashSet<>();

    @PostConstruct
    private void init() {
        questions.add(new Question("матВопрос1", "матОтвет1"));
        questions.add(new Question("матВопрос2", "матОтвет2"));
        questions.add(new Question("матВопрос3", "матОтвет3"));
        questions.add(new Question("матВопрос4", "матОтвет4"));
        questions.add(new Question("матВопрос5", "матОтвет5"));
    }

    @Override
    public Question add(String question, String answer) {
        validateParameter(question);
        validateParameter(answer);
        Question questionAdd = new Question(question, answer);
        questions.add(questionAdd);
        System.out.println("объект Question добавлен\n" +
                question + "\n" +
                answer + "\n");
        return questionAdd;
    }

    @Override
    public Question remove(String question, String answer) {
        validateParameter(question);
        validateParameter(answer);
        Question questionNeedRemove = new Question(question, answer);
        questions.remove(questionNeedRemove);
        System.out.println("объект Question удален\n" +
                question + "\n" +
                answer + "\n");
        return questionNeedRemove;
    }

    @Override
    public Set<Question> getAll() {
        for (Question question : questions) {
        }
        return questions;
    }

    private void validateParameter(String parameter) {
        if (parameter.equals("") || parameter.equals(" ")) {
            throw new ParameterIsNullException("пользователь забыл ввести вопрос либо ответ");
        }
    }
}
