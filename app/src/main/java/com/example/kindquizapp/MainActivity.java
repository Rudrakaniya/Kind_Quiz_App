package com.example.kindquizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    // Declare constants here
    private String mUserAnswer;
    private char mCurrentSelectedButton;
    private static final String TAG = "MainActivity";

    // Declare member variables here:
    Button mAnswerA;
    Button mAnswerB;
    Button mAnswerC;
    Button mAnswerD;

    Button mSubmitButton;
    Button mNextButton;
    TextView mQuestionTextView, mScoreTextView;
    int mIndex;
    int score = 0;
    boolean isQuestionAttempted = false;


    // The question Bank for quiz
    private QuestionChecker[] mQuestionBank = new QuestionChecker[]{
            new QuestionChecker(R.string.mQuestion1, R.string.mAnswer1, R.string.mQuestion1A, R.string.mQuestion1B, R.string.mQuestion1C, R.string.mQuestion1D),
            new QuestionChecker(R.string.mQuestion2, R.string.mAnswer2, R.string.mQuestion2A, R.string.mQuestion2B, R.string.mQuestion2C, R.string.mQuestion2D),
            new QuestionChecker(R.string.mQuestion3, R.string.mAnswer3, R.string.mQuestion3A, R.string.mQuestion3B, R.string.mQuestion3C, R.string.mQuestion3D),
            new QuestionChecker(R.string.mQuestion4, R.string.mAnswer4, R.string.mQuestion4A, R.string.mQuestion4B, R.string.mQuestion4C, R.string.mQuestion4D),
            new QuestionChecker(R.string.mQuestion5, R.string.mAnswer5, R.string.mQuestion5A, R.string.mQuestion5B, R.string.mQuestion5C, R.string.mQuestion5D),
            new QuestionChecker(R.string.mQuestion6, R.string.mAnswer6, R.string.mQuestion6A, R.string.mQuestion6B, R.string.mQuestion6C, R.string.mQuestion6D),
            new QuestionChecker(R.string.mQuestion7, R.string.mAnswer7, R.string.mQuestion7A, R.string.mQuestion7B, R.string.mQuestion7C, R.string.mQuestion7D),
            new QuestionChecker(R.string.mQuestion8, R.string.mAnswer8, R.string.mQuestion8A, R.string.mQuestion8B, R.string.mQuestion8C, R.string.mQuestion8D),
            new QuestionChecker(R.string.mQuestion9, R.string.mAnswer9, R.string.mQuestion9A, R.string.mQuestion9B, R.string.mQuestion9C, R.string.mQuestion9D),
            new QuestionChecker(R.string.mQuestion10, R.string.mAnswer10, R.string.mQuestion10A, R.string.mQuestion10B, R.string.mQuestion10C, R.string.mQuestion10D),
            new QuestionChecker(R.string.mQuestion11, R.string.mAnswer11, R.string.mQuestion11A, R.string.mQuestion11B, R.string.mQuestion11C, R.string.mQuestion11D),
            new QuestionChecker(R.string.mQuestion12, R.string.mAnswer12, R.string.mQuestion12A, R.string.mQuestion12B, R.string.mQuestion12C, R.string.mQuestion12D),
            new QuestionChecker(R.string.mQuestion13, R.string.mAnswer13, R.string.mQuestion13A, R.string.mQuestion13B, R.string.mQuestion13C, R.string.mQuestion13D)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // For selecting option buttons
        mAnswerA = findViewById(R.id.answer_A);
        mAnswerB = findViewById(R.id.answer_B);
        mAnswerC = findViewById(R.id.answer_C);
        mAnswerD = findViewById(R.id.answer_D);

        // Submit button and the Next button
        mSubmitButton = findViewById(R.id.submitButton);
        mNextButton = findViewById(R.id.nextButton);

        mQuestionTextView = findViewById(R.id.questionText);
        mScoreTextView = findViewById(R.id.mScoreValue);
        updateQuestion();
        mSubmitButton.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));

        mNextButton.setEnabled(false);

        mAnswerA.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isQuestionAttempted) {
                    setBackgroundToButtons('A');
                    mUserAnswer = mAnswerA.getText().toString();
                    mCurrentSelectedButton = 'A';
                } else {
                    Toast.makeText(MainActivity.this, "Select Next!!", Toast.LENGTH_SHORT).show();
                }


            }
        });

        mAnswerB.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!isQuestionAttempted) {
                    setBackgroundToButtons('B');
                    mUserAnswer = mAnswerB.getText().toString();
                    mCurrentSelectedButton = 'B';
                } else {
                    Toast.makeText(MainActivity.this, "Select Next!!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        mAnswerC.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!isQuestionAttempted) {
                    setBackgroundToButtons('C');
                    mUserAnswer = mAnswerC.getText().toString();
                    mCurrentSelectedButton = 'C';
                } else {
                    Toast.makeText(MainActivity.this, "Select Next!!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        mAnswerD.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!isQuestionAttempted) {
                    setBackgroundToButtons('D');
                    mUserAnswer = mAnswerD.getText().toString();
                    mCurrentSelectedButton = 'D';
                } else {
                    Toast.makeText(MainActivity.this, "Select Next!!", Toast.LENGTH_SHORT).show();
                }

            }
        });


        // Submit and Next Button clicking operations

        mSubmitButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mUserAnswer != null) {
                    checkAnswer(mUserAnswer, mCurrentSelectedButton);
                } else {
                    Toast.makeText(MainActivity.this, "Select option", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mNextButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mIndex += 1;
                resetOptions();
                updateQuestion();
                setButtonDisable();
            }
        });
    }



    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        score = savedInstanceState.getInt("score");
    }

    private void setBackgroundToButtons(char option) {

        switch (option) {
            case 'A': {
                mAnswerA.setBackgroundColor(ContextCompat.getColor(this, R.color.colorBlue));
                mAnswerB.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                mAnswerC.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                mAnswerD.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                break;
            }

            case 'B': {
                mAnswerA.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                mAnswerB.setBackgroundColor(ContextCompat.getColor(this, R.color.colorBlue));
                mAnswerC.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                mAnswerD.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                break;
            }

            case 'C': {
                mAnswerA.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                mAnswerB.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                mAnswerC.setBackgroundColor(ContextCompat.getColor(this, R.color.colorBlue));
                mAnswerD.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                break;
            }

            case 'D': {
                mAnswerA.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                mAnswerB.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                mAnswerC.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                mAnswerD.setBackgroundColor(ContextCompat.getColor(this, R.color.colorBlue));
                break;
            }
        }

    }

    private void updateQuestion() {

        if (mIndex >= mQuestionBank.length) {
            mIndex = mIndex % mQuestionBank.length;
            new MaterialAlertDialogBuilder(this)
                    .setTitle("Game Over!")
                    .setMessage("Your Total Score is "+ score +"/13")
                    .setPositiveButton("ReStart", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            score = 0;
                            mScoreTextView.setText(score + "/13");
                        }
                    })
                    .setCancelable(false)
                    .show();

        }

        QuestionChecker question = mQuestionBank[mIndex];
        mQuestionTextView.setText(question.getQuestionID());
        mAnswerA.setText(question.getOption1());
        mAnswerB.setText(question.getOption2());
        mAnswerC.setText(question.getOption3());
        mAnswerD.setText(question.getOption4());
        isQuestionAttempted = false;


    }

    private void checkAnswer(String userAnswer, char option) {

        QuestionChecker question = mQuestionBank[mIndex];
        Log.d(TAG, "checkAnswer: " + userAnswer);
        final String rightAnswer = getResources().getString(question.getAnswer());
        Log.d(TAG, "checkAnswer: " + rightAnswer);

        if (userAnswer.equals(rightAnswer)) {
            Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
            setRightBackground(rightAnswer);
            score += 1;
        } else {
            Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
            setWrongBackground(option);
            setRightBackground(rightAnswer);
        }
        mScoreTextView.setText(score + "/13");
        isQuestionAttempted = true;
        setButtonDisable();
        mUserAnswer = null;
    }

    private void resetOptions() {
        mAnswerA.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
        mAnswerB.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
        mAnswerC.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
        mAnswerD.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
    }

    private void setWrongBackground(char option) {
        switch (option) {
            case 'A': {
                mAnswerA.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
                break;
            }

            case 'B': {
                mAnswerB.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
                break;
            }

            case 'C': {
                mAnswerC.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
                break;
            }

            case 'D': {
                mAnswerD.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
                break;
            }
        }
    }

    private void setRightBackground(String rightAnswer) {
        char option = 'Z';

        String optA = mAnswerA.getText().toString();
        if (rightAnswer.equals(optA))
            option = 'A';

        String optB = mAnswerB.getText().toString();
        if (rightAnswer.equals(optB))
            option = 'B';

        String optC = mAnswerC.getText().toString();
        if (rightAnswer.equals(optC))
            option = 'C';

        String optD = mAnswerD.getText().toString();
        if (rightAnswer.equals(optD))
            option = 'D';

        switch (option) {
            case 'A': {
                mAnswerA.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen));
                break;
            }

            case 'B': {
                mAnswerB.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen));
                break;
            }

            case 'C': {
                mAnswerC.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen));
                break;
            }

            case 'D': {
                mAnswerD.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen));
                break;
            }
        }
    }

    private void setButtonDisable() {
        if (isQuestionAttempted){
            mSubmitButton.setEnabled(false);
            mNextButton.setEnabled(true);
            mSubmitButton.setBackgroundColor(Color.TRANSPARENT);
            mNextButton.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
        }else {
            mSubmitButton.setEnabled(true);
            mNextButton.setEnabled(false);
            mNextButton.setBackgroundColor(Color.TRANSPARENT);
            mSubmitButton.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));

        }
    }

}



















