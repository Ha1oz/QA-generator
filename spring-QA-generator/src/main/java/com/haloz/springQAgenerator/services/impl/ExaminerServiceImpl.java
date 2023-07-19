package com.haloz.springQAgenerator.services.impl;

import com.haloz.springQAgenerator.entities.Question;
import com.haloz.springQAgenerator.services.api.ExaminerService;
import com.haloz.springQAgenerator.services.api.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private Random random;
    private QuestionService questionService;
    @Override
    public List<Question> getQuestions(int amount) {
        return null;
    }
}
