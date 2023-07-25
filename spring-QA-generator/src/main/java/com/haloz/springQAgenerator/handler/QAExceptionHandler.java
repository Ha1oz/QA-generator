package com.haloz.springQAgenerator.handler;

import com.haloz.springQAgenerator.exceptions.QuestionIsAddedException;
import com.haloz.springQAgenerator.exceptions.QuestionIsNotFoundException;
import com.haloz.springQAgenerator.exceptions.QuestionMethodIsNotAllowedException;
import com.haloz.springQAgenerator.exceptions.SectionIsNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class QAExceptionHandler {
    private final static Logger LOGGER = LoggerFactory.getLogger(QAExceptionHandler.class);

    @ExceptionHandler(QuestionIsNotFoundException.class)
    public ResponseEntity<Object> handleQuestionIsNotFoundException(QuestionIsNotFoundException e) {
        LOGGER.error(e.toString());
        return new ResponseEntity<>("Question is not found.", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(QuestionIsAddedException.class)
    public ResponseEntity<Object> handleQuestionIsAddedException(QuestionIsAddedException e) {
        LOGGER.error(e.toString());
        return new ResponseEntity<>("Question is already added.", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<Object> handleArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException e) {
        LOGGER.error(e.toString());
        return new ResponseEntity<>("That amount of questions cannot be given.", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(SectionIsNotFoundException.class)
    public ResponseEntity<Object> handleSectionIsNotFoundException(SectionIsNotFoundException e) {
        LOGGER.error(e.toString());
        return new ResponseEntity<>("Section is not found. Try again.", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(QuestionMethodIsNotAllowedException.class)
    public ResponseEntity<Object> handleQuestionMethodIsNotAllowedException(QuestionMethodIsNotAllowedException e) {
        LOGGER.error(e.toString());
        return new ResponseEntity<>("Method is forbidden.", HttpStatus.METHOD_NOT_ALLOWED);
    }
}
