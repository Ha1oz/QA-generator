package com.haloz.springQAgenerator.controllers;

import com.haloz.springQAgenerator.entities.Question;
import com.haloz.springQAgenerator.services.QuestionServiceFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class QuestionController {
    private final QuestionServiceFactory questionServiceFactory;

    public QuestionController(QuestionServiceFactory questionServiceFactory) {
        this.questionServiceFactory = questionServiceFactory;
    }

    @GetMapping("/{type}/add")
    public Question add(@PathVariable String type, String ques, String ans) {
        return questionServiceFactory.getQuestionService(type).addQuestion(ques, ans);
    }
    @GetMapping("/{type}/remove")
    public Question remove(@PathVariable String type, String ques, String ans) {
        Question question = new Question(ques, ans);
        return questionServiceFactory.getQuestionService(type).removeQuestion(question);
    }
    @GetMapping("/{type}")
    public List<Question> all(@PathVariable String type) {
        return questionServiceFactory.getQuestionService(type).getAllQuestions();
    }

}
