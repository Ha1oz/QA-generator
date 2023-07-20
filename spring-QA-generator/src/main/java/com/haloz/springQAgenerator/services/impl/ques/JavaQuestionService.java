package com.haloz.springQAgenerator.services.impl.ques;

import com.haloz.springQAgenerator.repo.QuestionRepository;
import com.haloz.springQAgenerator.services.api.ques.QuestionService;
import org.springframework.stereotype.Service;


@Service
public class JavaQuestionService extends QuestionService {
    private static final String JAVA_SECTION = "java";
    public JavaQuestionService(QuestionRepository questionRepository) {
        super(questionRepository, JAVA_SECTION);
    }
}
