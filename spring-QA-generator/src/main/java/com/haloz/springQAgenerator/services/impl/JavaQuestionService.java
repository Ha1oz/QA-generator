package com.haloz.springQAgenerator.services.impl;

import com.haloz.springQAgenerator.entities.Question;
import com.haloz.springQAgenerator.repo.QuestionRepository;
import com.haloz.springQAgenerator.services.api.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {
    private static final String JAVA_SECTION = "Java";
    private final QuestionRepository questionRepository;
    public JavaQuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
    @Override
    public Question addQuestion(String questionStr, String answerStr) {
        Question question = new Question(questionStr, answerStr);
        questionRepository.add(JAVA_SECTION, question);
        return question;
    }
    @Override
    public Question addQuestion(Question question) {
        questionRepository.add(JAVA_SECTION, question);
        return question;
    }
    @Override
    public Question removeQuestion(Question question) {
        questionRepository.remove(JAVA_SECTION, question);
        return question;
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.getAll(JAVA_SECTION);
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        List<Question> questions = questionRepository.getAll(JAVA_SECTION);

        return questions.get(random.nextInt(questions.size()));
    }
}
