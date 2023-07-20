package com.haloz.springQAgenerator.services.impl.ques;

import com.haloz.springQAgenerator.repo.QuestionRepository;
import com.haloz.springQAgenerator.services.api.ques.QuestionService;
import org.springframework.stereotype.Service;

@Service
public class MathQuestionService extends QuestionService {
    private static final String MATH_SECTION = "math";
    public MathQuestionService(QuestionRepository questionRepository) {
        super(questionRepository, MATH_SECTION);
    }
}
