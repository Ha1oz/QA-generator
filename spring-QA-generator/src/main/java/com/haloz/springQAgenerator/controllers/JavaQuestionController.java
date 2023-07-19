package com.haloz.springQAgenerator.controllers;

import com.haloz.springQAgenerator.entities.Question;
import com.haloz.springQAgenerator.services.api.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(@Qualifier("javaQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question add(String ques, String ans) {
        return questionService.addQuestion(ques, ans);
    }
    @GetMapping("/remove")
    public Question remove(String ques, String ans) {
        Question question = new Question(ques, ans);
        return questionService.removeQuestion(question);
    }
    @GetMapping
    public List<Question> all() {
        return questionService.getAllQuestions();
    }

}
