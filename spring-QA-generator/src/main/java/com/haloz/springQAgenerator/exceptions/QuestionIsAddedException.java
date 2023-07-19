package com.haloz.springQAgenerator.exceptions;

public class QuestionIsAddedException extends RuntimeException{
    public QuestionIsAddedException() {
    }

    public QuestionIsAddedException(String message) {
        super(message);
    }
}
