package com.haloz.springQAgenerator.services.impl;

import com.haloz.springQAgenerator.entities.Question;
import com.haloz.springQAgenerator.services.QuestionServiceFactory;
import com.haloz.springQAgenerator.services.api.ExaminerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    @Autowired
    private QuestionServiceFactory questionServiceFactory;

    public ExaminerServiceImpl(QuestionServiceFactory questionServiceFactory) {
        this.questionServiceFactory = questionServiceFactory;
    }
    @Override
    public Set<Question> getQuestions(String type, int amount) {
        return getRandomQuestions(type, amount);
    }

    private Set<Question> getRandomQuestions(String type, int amount) {
        Set<Question> questionSet = new HashSet<>();
        while (questionSet.size() != amount) {
            questionSet.add(questionServiceFactory.getQuestionService(type).getRandomQuestion());
        }
        return questionSet;
    }
}
