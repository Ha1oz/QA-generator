package com.haloz.springQAgenerator.services.impl;

import com.haloz.springQAgenerator.entities.Question;
import com.haloz.springQAgenerator.services.QuestionServiceFactory;
import com.haloz.springQAgenerator.services.api.ExaminerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final Random random;
    @Autowired
    private QuestionServiceFactory questionServiceFactory;

    public ExaminerServiceImpl(QuestionServiceFactory questionServiceFactory) {
        this.random = new Random();
        this.questionServiceFactory = questionServiceFactory;
    }
    @Override
    public List<Question> getQuestions(String type, int amount) {
        List<Question> buff = questionServiceFactory.getQuestionService(type).getAllQuestions();

        if(amount > buff.size() || amount < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        List<Question> res = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            int randomIndex = random.nextInt(buff.size());
            res.add(buff.get(randomIndex));
            buff.remove(randomIndex);
        }

        return res;
    }
}
