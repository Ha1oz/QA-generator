package com.haloz.springQAgenerator.services;

import com.haloz.springQAgenerator.exceptions.SectionIsNotFoundException;
import com.haloz.springQAgenerator.services.api.ques.QuestionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class QuestionServiceFactory {
    @Resource(name = "mapBean")
    private final Map<String, QuestionService> factory;

    public QuestionServiceFactory(Map<String, QuestionService> factory) {
        this.factory = factory;
    }

    public QuestionService getQuestionService(String typeQS) {
        if (!factory.containsKey(typeQS)) {
            throw new SectionIsNotFoundException();
        }
        return factory.get(typeQS);
    }
}
