package com.haloz.springQAgenerator.repo;

import com.haloz.springQAgenerator.entities.Question;
import com.haloz.springQAgenerator.exceptions.QuestionIsAddedException;
import com.haloz.springQAgenerator.exceptions.QuestionIsNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class QuestionRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionRepository.class);
    private final Map<String, List<Question>> questionsBase;

    public QuestionRepository() {
        this.questionsBase = new HashMap<>();
    }
    public void add(String section, Question question) {
        if (!questionsBase.containsKey(section)) {
            questionsBase.put(section, new ArrayList<>());
            LOGGER.info(String.format("New section {%s} is added.", section));
        }
        if (questionsBase.get(section).contains(question)){
            LOGGER.info(String.format("Question {%s} is already added.", section));
            throw new QuestionIsAddedException();
        }
        questionsBase.get(section).add(question);
        LOGGER.info(String.format("Question {%s} is added.", question));
    }
    public void remove(String section, Question question) {
        if (!questionsBase.containsKey(section)) {
            throw new QuestionIsNotFoundException();
        }
        if(questionsBase.get(section).remove(question)) {
            LOGGER.info(String.format("Question {%s} is removed.", question));
        }
    }
    public List<Question> getAll(String section) {
        LOGGER.info("Questions is showed.");

        List<Question> res = questionsBase.get(section);
        return res != null ? new ArrayList<>(res) : new ArrayList<>();
    }
}
