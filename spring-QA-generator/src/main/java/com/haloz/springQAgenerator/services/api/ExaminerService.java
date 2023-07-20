package com.haloz.springQAgenerator.services.api;

import com.haloz.springQAgenerator.entities.Question;

import java.util.List;

public interface ExaminerService {
    List<Question> getQuestions(int amount);
}
