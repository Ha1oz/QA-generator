package com.haloz.springQAgenerator.repo;

import com.haloz.springQAgenerator.entities.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionRepositoryTest {
    private QuestionRepository questionRepository;
    private Question question, question1;
    private String section;
    @BeforeEach
    void setUp() {
        questionRepository = new QuestionRepository();
        section = "Java";
        question = new Question("Java is good or bad?", "Perfect");
        question1 = new Question("C# is bad or bad-bad-bad?", "Terrible!!!");
    }

    @Test
    void addAndGetAll() {
        List<Question> questions = new ArrayList<>();
        questions.add(question);
        questions.add(question1);

        questionRepository.add(section, question);
        questionRepository.add(section, question1);

        Assertions.assertEquals(questions, questionRepository.getAll(section));

    }
    @Test
    void remove() {
        addAndGetAll();
        questionRepository.remove(section, question1);

        Assertions.assertFalse(questionRepository.getAll(section).contains(question1));
    }
}