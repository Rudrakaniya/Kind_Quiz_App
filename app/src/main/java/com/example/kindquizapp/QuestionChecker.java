package com.example.kindquizapp;

public class QuestionChecker {
    private int mQuestionID;
    private int mAnswer;

    public QuestionChecker(int questionResourceID, int correctAnswer){
        mQuestionID = questionResourceID;
        mAnswer = correctAnswer;

        // I am typing this text from my new keyboard, which i have just installed in my new laptop table
        // I am feeling good vibes by typing from my this new keyboard.

    }

    public int getQuestionID(){
        return mQuestionID;
    }

    public void setQuestionID(int questionID){
        mQuestionID = questionID;
    }

    public int isAnswer() {
        return mAnswer;
    }

    public void getQuestionID(int answer){
        mAnswer = answer;
    }
}
