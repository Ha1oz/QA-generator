package com.haloz.springQAgenerator.controllers;

import com.haloz.springQAgenerator.entities.Question;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {
    public List<Question> getQuestions(int amount) {
        return null;
    }
}
