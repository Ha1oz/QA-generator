package com.haloz.springQAgenerator.exceptions;

public class QuestionIsNotFoundException extends RuntimeException{
    public QuestionIsNotFoundException() {
    }

    public QuestionIsNotFoundException(String message) {
        super(message);
    }
}
