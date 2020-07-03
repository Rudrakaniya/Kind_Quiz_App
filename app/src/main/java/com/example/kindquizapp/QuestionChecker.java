package com.example.kindquizapp;

public class QuestionChecker {
    private int mQuestionID;
    private String mAnswer;

    public QuestionChecker(int questionresourceID, String correctAnswer){
        mQuestionID = questionresourceID;
        mAnswer = correctAnswer;
    }
}
