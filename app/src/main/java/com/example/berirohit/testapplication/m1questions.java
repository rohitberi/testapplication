package com.example.berirohit.testapplication;

import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

public class m1questions extends AppCompatActivity {

    classM1Questions oQuestions;
    ImageView imgPrevQuestion, imgNextQuestion, imgQuestion;
    TextView txtbottom;
    TextView txtQuestionM1;
    RadioButton rbtnAnswer1, rbtnAnswer2, rbtnAnswer3, rbtnAnswer4;
//    RadioGroup rgrpAnswers;
    String sAnswer = "";

    private final String LOGTYPE = "INFORMATION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m1questions);

        imgPrevQuestion = (ImageView) findViewById(R.id.imgPrevQuestion);
        imgNextQuestion = (ImageView) findViewById(R.id.imgNextQuestion);
        imgQuestion = (ImageView) findViewById(R.id.imgQuestionM1);
        txtbottom = (TextView) findViewById(R.id.txtbottom);
        txtQuestionM1 = (TextView) findViewById(R.id.txtQuestionM1);
        rbtnAnswer1 = (RadioButton) findViewById(R.id.rbtnAnswer1);
        rbtnAnswer2 = (RadioButton) findViewById(R.id.rbtnAnswer2);
        rbtnAnswer3 = (RadioButton) findViewById(R.id.rbtnAnswer3);
        rbtnAnswer4 = (RadioButton) findViewById(R.id.rbtnAnswer4);

        imgPrevQuestion.setOnClickListener(new OnImageButtonClick());
        imgNextQuestion.setOnClickListener(new OnImageButtonClick());

        rbtnAnswer1.setOnClickListener(new OnImageButtonClick());
        rbtnAnswer2.setOnClickListener(new OnImageButtonClick());
        rbtnAnswer3.setOnClickListener(new OnImageButtonClick());
        rbtnAnswer4.setOnClickListener(new OnImageButtonClick());

        try {
            oQuestions = new classM1Questions();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        oQuestions.firstQuestion();
        fnRefreshUI();
    }

    public class OnImageButtonClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Boolean bContinue = false;
            switch (view.getId()) {
                case R.id.imgPrevQuestion:
                    Log.i(LOGTYPE, "case: imgPrevQuestion");
                    bContinue = oQuestions.previousQuestion();
                    if (bContinue){
                        // set all question text and answers
                        fnRefreshUI();
                    }
                    break;

                case R.id.imgNextQuestion:
                    Log.i(LOGTYPE, "case: imgNextQuestion");
                    bContinue = oQuestions.nextQuestion();
                    if (bContinue){
                        // set all question text and answers
                        fnRefreshUI();
                    }
                    break;

                case R.id.rbtnAnswer1:
                    Log.i(LOGTYPE, "case: Radio Button 1 Clicked");
                    Toast.makeText(m1questions.this, "Radio Button 1 Clicked", Toast.LENGTH_SHORT).show();

                    if (oQuestions.fnCheckAnswer("A", oQuestions.get_CurrentQuestionCounter())){
                        Toast.makeText(m1questions.this, "!!!! CORRECT ANSWER !!!!", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(m1questions.this, "INCORRECT ANSWER", Toast.LENGTH_SHORT).show();
                    }
                    break;

                case R.id.rbtnAnswer2:
                    Log.i(LOGTYPE, "case: Radio Button 2 Clicked");
                    Toast.makeText(m1questions.this, "Radio Button 2 Clicked", Toast.LENGTH_SHORT).show();

                    if (oQuestions.fnCheckAnswer("B", oQuestions.get_CurrentQuestionCounter())){
                        Toast.makeText(m1questions.this, "!!!! CORRECT ANSWER !!!!", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(m1questions.this, "INCORRECT ANSWER", Toast.LENGTH_SHORT).show();
                    }

                    break;

                case R.id.rbtnAnswer3:
                    Log.i(LOGTYPE, "case: Radio Button 3 Clicked");
                    Toast.makeText(m1questions.this, "Radio Button 3 Clicked", Toast.LENGTH_SHORT).show();

                    if (oQuestions.fnCheckAnswer("C", oQuestions.get_CurrentQuestionCounter())){
                        Toast.makeText(m1questions.this, "!!!! CORRECT ANSWER !!!!", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(m1questions.this, "INCORRECT ANSWER", Toast.LENGTH_SHORT).show();
                    }

                    break;

                case R.id.rbtnAnswer4:
                    Log.i(LOGTYPE, "case: Radio Button 4 Clicked");
                    Toast.makeText(m1questions.this, "Radio Button 4 Clicked", Toast.LENGTH_SHORT).show();

                    if (oQuestions.fnCheckAnswer("D", oQuestions.get_CurrentQuestionCounter())){
                        Toast.makeText(m1questions.this, "!!!! CORRECT ANSWER !!!!", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(m1questions.this, "INCORRECT ANSWER", Toast.LENGTH_SHORT).show();
                    }

                    break;
            }
        }
    }

    void fnRefreshUI() {
        txtQuestionM1.setText(oQuestions.get_sQuestion());
        sAnswer = oQuestions.get_sAnswer();
        imgQuestion.setImageResource(oQuestions.get_iImgQuestion());
        rbtnAnswer1.setText(oQuestions.get_sAnswer1());
        rbtnAnswer2.setText(oQuestions.get_sAnswer2());
        rbtnAnswer3.setText(oQuestions.get_sAnswer3());
        rbtnAnswer4.setText(oQuestions.get_sAnswer4());
        txtbottom.setText("Question: " + String.valueOf(oQuestions.get_CurrentQuestionCounter() + 1) + " of " + String.valueOf(oQuestions.get_MaxQuestions())  );
        rbtnAnswer1.setChecked(false);
        rbtnAnswer2.setChecked(false);
        rbtnAnswer3.setChecked(false);
        rbtnAnswer4.setChecked(false);
    }
}
