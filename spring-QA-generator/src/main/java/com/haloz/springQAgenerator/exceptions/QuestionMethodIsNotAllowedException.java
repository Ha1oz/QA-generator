package com.haloz.springQAgenerator.exceptions;

public class QuestionMethodIsNotAllowedException extends RuntimeException{
    public QuestionMethodIsNotAllowedException() {
    }

    public QuestionMethodIsNotAllowedException(String message) {
        super(message);
    }
}
