package com.example.kindquizapp;

public class QuestionChecker {
    private int mQuestionID;
    private int mAnswer;
    private int mOption1;
    private int mOption2;
    private int mOption3;
    private int mOption4;

    public QuestionChecker(int questionID, int answer, int option1, int option2, int option3, int option4) {
        mQuestionID = questionID;
        mAnswer = answer;
        mOption1 = option1;
        mOption2 = option2;
        mOption3 = option3;
        mOption4 = option4;
    }

    public int getQuestionID() {
        return mQuestionID;
    }

    public void setQuestionID(int questionID) {
        mQuestionID = questionID;
    }

    public int getAnswer() {
        return mAnswer;
    }

    public void setAnswer(int answer) {
        mAnswer = answer;
    }

    public int getOption1() {
        return mOption1;
    }

    public void setOption1(int option1) {
        mOption1 = option1;
    }

    public int getOption2() {
        return mOption2;
    }

    public void setOption2(int option2) {
        mOption2 = option2;
    }

    public int getOption3() {
        return mOption3;
    }

    public void setOption3(int option3) {
        mOption3 = option3;
    }

    public int getOption4() {
        return mOption4;
    }

    public void setOption4(int option4) {
        mOption4 = option4;
    }
}
