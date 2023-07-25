package com.haloz.springQAgenerator.services.api;

import com.haloz.springQAgenerator.entities.Question;

import java.util.Set;

public interface ExaminerService {
    Set<Question> getQuestions(String type, int amount);
}
