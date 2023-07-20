package com.haloz.springQAgenerator.config;

import com.haloz.springQAgenerator.services.api.ques.QuestionService;
import com.haloz.springQAgenerator.services.impl.ques.JavaQuestionService;
import com.haloz.springQAgenerator.services.impl.ques.MathQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class QAConfig {
    @Autowired
    private JavaQuestionService javaQuestionService;
    @Autowired
    private MathQuestionService mathQuestionService;
    @Bean(name = "mapBean")
    public Map<String, QuestionService> mapBean() {
        Map<String, QuestionService> newMap = new HashMap<>();
        newMap.put(javaQuestionService.getSection(), javaQuestionService);
        newMap.put(mathQuestionService.getSection(), mathQuestionService);
        return newMap;
    }
}
