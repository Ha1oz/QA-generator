package com.haloz.springQAgenerator.services.impl.ques;

import com.haloz.springQAgenerator.entities.Question;
import com.haloz.springQAgenerator.exceptions.QuestionMethodIsNotAllowedException;
import com.haloz.springQAgenerator.repo.QuestionRepository;
import com.haloz.springQAgenerator.services.api.ques.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class MathQuestionService extends QuestionService {
    private static final String MATH_SECTION = "math";
    private static final int MATH_QUESTION_BOUND = 100;
    private static final int OPERATION_QUESTION_COUNT = 3;
    public MathQuestionService(QuestionRepository questionRepository) {
        super(questionRepository, MATH_SECTION);
    }

    @Override
    public Question addQuestion(String questionStr, String answerStr) {
        throw new QuestionMethodIsNotAllowedException();
    }
    @Override
    public Question addQuestion(Question question) {
        throw new QuestionMethodIsNotAllowedException();
    }
    @Override
    public Question removeQuestion(Question question) {
        throw new QuestionMethodIsNotAllowedException();
    }
    @Override
    public List<Question> getAllQuestions() {
        throw new QuestionMethodIsNotAllowedException();
    }
    @Override
    public Question getRandomQuestion() {
        return generateMathQuestion();
    }
    private Question generateMathQuestion() {
        Random random = new Random();
        Integer val1 = random.nextInt(MATH_QUESTION_BOUND);
        Integer val2 = random.nextInt(MATH_QUESTION_BOUND);
        int rnd = random.nextInt(OPERATION_QUESTION_COUNT);

        switch (rnd) {
            case 0 -> {
                return plusQuestion(val1, val2);
            }
            case 1 -> {
                return minusQuestion(val1, val2);
            }
            case 2 -> {
                return multiplyQuestion(val1, val2);
            }
        }
        return plusQuestion(val1, val2);
    }
    private Question plusQuestion(Integer a, Integer b) {
        int res = a + b;
        String quesStr = a + " + " + b + " = ?";
        String ansStr = Integer.toString(res);

        return new Question(quesStr, ansStr);
    }
    private Question minusQuestion(Integer a, Integer b) {
        int res = a - b;
        String quesStr = a + " - " + b + " = ?";
        String ansStr = Integer.toString(res);

        return new Question(quesStr, ansStr);
    }
    private Question multiplyQuestion(Integer a, Integer b) {
        int res = a * b;
        String quesStr = a + " * " + b + " = ?";
        String ansStr = Integer.toString(res);

        return new Question(quesStr, ansStr);
    }
}
