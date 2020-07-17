package com.example.kindquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declare constants here


    // Declare member variables here:
    Button mAnswerA;
    Button mAnswerB;
    Button mAnswerC;
    Button mAnswerD;

    Button mSubmitButton;
    Button mNextButton;
    TextView mQuestionTextView;
    int mIndex;
    int mQuestion;

    // The question Bank for quiz
    private QuestionChecker[] mQuestionBank = new QuestionChecker[] {
            new QuestionChecker( R.string.mQuestion1, R.string.mAnswer1),
            new QuestionChecker( R.string.mQuestion2, R.string.mAnswer2),
            new QuestionChecker( R.string.mQuestion3, R.string.mAnswer3),
            new QuestionChecker( R.string.mQuestion4, R.string.mAnswer4),
            new QuestionChecker( R.string.mQuestion5, R.string.mAnswer5),
            new QuestionChecker( R.string.mQuestion6, R.string.mAnswer6),
            new QuestionChecker( R.string.mQuestion7, R.string.mAnswer7),
            new QuestionChecker( R.string.mQuestion8, R.string.mAnswer8),
            new QuestionChecker( R.string.mQuestion9, R.string.mAnswer9),
            new QuestionChecker( R.string.mQuestion10, R.string.mAnswer10),
            new QuestionChecker( R.string.mQuestion11, R.string.mAnswer11),
            new QuestionChecker( R.string.mQuestion12, R.string.mAnswer12),
            new QuestionChecker( R.string.mQuestion13, R.string.mAnswer13)
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

        mQuestion = mQuestionBank[mIndex].getQuestionID();
        mQuestionTextView.setText(mQuestion);

        mAnswerA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Kids_Quiz_App", "A Button Pressed!");
                Toast.makeText(getApplicationContext(), "A Pressed!!", Toast.LENGTH_SHORT).show();
            }
        });

        mAnswerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Kids_Quiz_App", "B Button Pressed!");
                Toast.makeText(getApplicationContext(), "B Pressed!!", Toast.LENGTH_SHORT).show();
            }
        });

        mAnswerC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Kids_Quiz_App", "C Button Pressed!");
                Toast.makeText(getApplicationContext(), "C Pressed!!", Toast.LENGTH_SHORT).show();
            }
        });

        mAnswerD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Kids_Quiz_App", "D Button Pressed!");
                Toast.makeText(getApplicationContext(), "D Pressed!!", Toast.LENGTH_SHORT).show();
            }
        });


        // Submit and Next Button clicking operations

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Kids_Quiz_App", "Submit Button Pressed!");
                Toast.makeText(getApplicationContext(), "Submit Button Pressed!!", Toast.LENGTH_SHORT).show();
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Kids_Quiz_App", "Next Button Pressed!");
                Toast.makeText(getApplicationContext(), "Next Button Pressed!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateQuestion(){
        mIndex = (mIndex + 1 );

        if (mIndex >= mQuestionBank.length){
            mIndex = mIndex % mQuestionBank.length;
        }
        mQuestion = mQuestionBank[mIndex].getQuestionID();
        mQuestionTextView.setText(mQuestion);
    }

    private void checkAnswer(int userSelection) {
        int correctAnswer = mQuestionBank[mIndex].isAnswer();

        if (userSelection == correctAnswer){
            Toast.makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_SHORT);
        }
        else {
            Toast.makeText(getApplicationContext(), R.string.incorrect_toast, Toast.LENGTH_SHORT);
        }
    }

}