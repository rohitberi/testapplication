package com.example.berirohit.testapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class m1questions extends AppCompatActivity {

    classM1Questions oQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m1questions);

        oQuestions = new classM1Questions();
        oQuestions.NextQuestion();
    }
}
