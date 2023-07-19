package com.haloz.springQAgenerator.services.impl;

import com.haloz.springQAgenerator.repo.QuestionRepository;
import com.haloz.springQAgenerator.services.api.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("mathQuestionService")
public class MathQuestionService extends QuestionService {
    private static final String MATH_SECTION = "Math";
    public MathQuestionService(QuestionRepository questionRepository) {
        super(questionRepository, MATH_SECTION);
    }
}
