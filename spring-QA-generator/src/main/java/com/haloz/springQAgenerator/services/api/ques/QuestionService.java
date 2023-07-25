package com.haloz.springQAgenerator.services.api.ques;

import com.haloz.springQAgenerator.entities.Question;
import com.haloz.springQAgenerator.repo.QuestionRepository;

import java.util.List;
import java.util.Random;

public abstract class QuestionService {
    private final String section;
    protected final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository, String section) {
        this.questionRepository = questionRepository;
        this.section = section;
    }
    public Question addQuestion(String questionStr, String answerStr) {
        Question question = new Question(questionStr, answerStr);
        questionRepository.add(section, question);
        return question;
    }
    public Question addQuestion(Question question) {
        questionRepository.add(section, question);
        return question;
    }
    public Question removeQuestion(Question question) {
        questionRepository.remove(section, question);
        return question;
    }

    public List<Question> getAllQuestions() {
        return questionRepository.getAll(section);
    }

    public Question getRandomQuestion() {
        Random random = new Random();
        List<Question> questions = questionRepository.getAll(section);

        return questions.get(random.nextInt(questions.size()));
    }
    public String getSection() {
        return section;
    }
}
