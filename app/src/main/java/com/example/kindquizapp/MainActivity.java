package com.example.kindquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // For selecting option A
        mAnswerA = findViewById(R.id.answer_A);

        // For selecting option B
        mAnswerB = findViewById(R.id.answer_B);

        // For selecting option C
        mAnswerC = findViewById(R.id.answer_C);

        // For selecting option D
        mAnswerD = findViewById(R.id.answer_D);

        // Submit button and the Next button
        mSubmitButton = findViewById(R.id.submitButton);
        mNextButton = findViewById(R.id.nextButton);

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
}