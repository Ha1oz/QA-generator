package com.haloz.springQAgenerator.services.impl;

import com.haloz.springQAgenerator.entities.Question;
import com.haloz.springQAgenerator.repo.QuestionRepository;
import com.haloz.springQAgenerator.services.api.QuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class QuestionServiceTest {
    private Question question;
    private QuestionService questionService;
    @Mock
    private QuestionRepository questionRepositoryMock;

    @BeforeEach
    void setUp() {
        questionService = new JavaQuestionService(questionRepositoryMock);
        question = new Question("A", "B");
    }
    @Test
    void add() {
        questionService.addQuestion(question);
        Mockito.verify(questionRepositoryMock, Mockito.times(1)).add(Mockito.any(), Mockito.any());
    }

    @Test
    void remove() {
        questionService.removeQuestion(question);
        Mockito.verify(questionRepositoryMock, Mockito.times(1)).remove(Mockito.any(), Mockito.any());
    }

    @Test
    void getAll() {
        List<Question> expected = new ArrayList<>();
        expected.add(question);

        Mockito.doReturn(expected).when(questionRepositoryMock).getAll(Mockito.anyString());
        Assertions.assertEquals(expected, questionService.getAllQuestions());
    }

    @Test
    void getRandomQuestion() {
        List<Question> expected = new ArrayList<>();
        expected.add(question);

        Mockito.doReturn(expected).when(questionRepositoryMock).getAll(Mockito.anyString());
        Assertions.assertEquals(question, questionService.getRandomQuestion());
    }
}