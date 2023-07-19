package com.haloz.springQAgenerator.services.impl;

import com.haloz.springQAgenerator.entities.Question;
import com.haloz.springQAgenerator.services.api.ExaminerService;
import com.haloz.springQAgenerator.services.api.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final Random random;
    private final QuestionService questionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService questionService) {
        this.random = new Random();
        this.questionService = questionService;
    }

    @Override
    public List<Question> getQuestions(int amount) {
        List<Question> buff = questionService.getAllQuestions();

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
