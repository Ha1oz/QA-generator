package com.haloz.springQAgenerator.services.api;

import com.haloz.springQAgenerator.entities.Question;

import java.util.List;

public interface QuestionService {
    Question addQuestion(String questionStr, String answerStr);
    Question addQuestion(Question question);
    Question removeQuestion(Question question);
    List<Question> getAllQuestions();
    Question getRandomQuestion();
}
