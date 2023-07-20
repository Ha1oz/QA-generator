package com.haloz.springQAgenerator.services.impl;

import com.haloz.springQAgenerator.repo.QuestionRepository;
import com.haloz.springQAgenerator.services.api.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
@Qualifier("javaQuestionService")
public class JavaQuestionService extends QuestionService {
    private static final String JAVA_SECTION = "Java";
    public JavaQuestionService(QuestionRepository questionRepository) {
        super(questionRepository, JAVA_SECTION);
    }
}
