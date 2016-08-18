package com.example.berirohit.testapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class m1questions extends AppCompatActivity {

    classM1Questions oQuestions;
    ImageView imgPrevQuestion;
    ImageView imgNextQuestion;
    TextView txtbottom;
    private final String LOGTYPE = "INFORMATION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m1questions);

        oQuestions = new classM1Questions();
        oQuestions.firstQuestion();

        imgPrevQuestion = (ImageView) findViewById(R.id.imgPrevQuestion);
        imgNextQuestion = (ImageView) findViewById(R.id.imgNextQuestion);
        txtbottom = (TextView) findViewById(R.id.txtbottom);

        imgPrevQuestion.setOnClickListener(new OnImageButtonClick());
        imgNextQuestion.setOnClickListener(new OnImageButtonClick());
    }

    public class OnImageButtonClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Boolean bContinue = false;
            switch (view.getId()) {
                case R.id.imgPrevQuestion:
                    Log.i(LOGTYPE, "case: imgPrevQuestion");
                    bContinue = oQuestions.previousQuestion();
                    if (bContinue == true){
                        // set all question text and answers
                    }
                    break;

                case R.id.imgNextQuestion:
                    Log.i(LOGTYPE, "case: imgNextQuestion");
                    bContinue = oQuestions.nextQuestion();
                    if (bContinue == true){
                        // set all question text and answers
                    }
                    break;

            }
        }
    }
}
