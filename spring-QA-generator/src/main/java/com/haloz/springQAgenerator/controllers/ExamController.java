package com.haloz.springQAgenerator.controllers;

import com.haloz.springQAgenerator.entities.Question;
import com.haloz.springQAgenerator.services.api.ExaminerService;
import com.haloz.springQAgenerator.services.impl.ExaminerServiceImpl;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    @NonNull
    public List<Question> getQuestions(@PathVariable Integer amount) {
        return examinerService.getQuestions(amount);
    }
}
