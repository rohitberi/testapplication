package com.example.berirohit.testapplication;

import android.util.Log;

/**
 * Created by roberi on 8/3/2016.
 */

public class classM1Questions {
    private int iCounter = 0;
    private final String LOGTYPE = "INFORMATION";
    private final static int IMAXQUESTIONS = 5;

    private String sQuestion = "";
    private int iImgQuestion;
    private String sAnswer = "";
    private String sAnswer1 = "";
    private String sAnswer2 = "";
    private String sAnswer3 = "";
    private String sAnswer4 = "";

    // these variables relate to the question that is in memory / being displayed on the UI
    private int iQuestion = 0;

    protected void classM1Questions(){
        iCounter = 0;
    }

    void firstQuestion(){

        iCounter = 1;
        Log.i(LOGTYPE, "function: previousQuestion: " + String.valueOf(iCounter));
        readQuestion(iCounter);
    }

    Boolean nextQuestion(){
        iCounter ++;    // counter starts at 0; before reading next question we move the counter up by 1
        Log.i(LOGTYPE, "function: nextQuestion: " + String.valueOf(iCounter));

        if(iCounter <= IMAXQUESTIONS){
            readQuestion(iCounter);
            return true;
        }else{
            iCounter --;  // reset back to last question counter
            Log.i(LOGTYPE, "function: nextQuestion: End of Questions reached");
            return false;
        }
    }

    Boolean previousQuestion(){

        iCounter --;
        Log.i(LOGTYPE, "function: previousQuestion: " + String.valueOf(iCounter));
        if (iCounter > 0){
            readQuestion(iCounter);
            return true;
        }else{
            iCounter ++;  // reset back to last question counter
            Log.i(LOGTYPE, "function: previousQuestion: End of Questions reached");
            return false;
        }
    }

    void readQuestion(int iCount){
        // this function will read the contents of a question into memory
        Log.i(LOGTYPE, "function: readQuestion: " + String.valueOf(iCounter));
        switch (iCount){
            case 1 :
                sQuestion =  "This is Question 1"; //R.array.m1Q1[0];
                sAnswer = "A";
                iImgQuestion = R.drawable.m1q1;
                sAnswer1 = "Answer 1 for Question 1";
                sAnswer2 = "Answer 2 for Question 1";
                sAnswer3 = "Answer 3 for Question 1";
                sAnswer4 = "Answer 4 for Question 1";
            break;

            case 2:
                sQuestion =  "This is Question 2"; //R.array.m1Q1[0];
                sAnswer = "A";
                iImgQuestion = R.drawable.m1q2;
                sAnswer1 = "Answer 1 for Question 2";
                sAnswer2 = "Answer 2 for Question 2";
                sAnswer3 = "Answer 3 for Question 2";
                sAnswer4 = "Answer 4 for Question 2";
                break;

            case 3:
                sQuestion =  "This is Question 3"; //R.array.m1Q1[0];
                sAnswer = "A";
                iImgQuestion = R.drawable.m1q3;
                sAnswer1 = "Answer 1 for Question 3";
                sAnswer2 = "Answer 2 for Question 3";
                sAnswer3 = "Answer 3 for Question 3";
                sAnswer4 = "Answer 4 for Question 3";
                break;

            case 4:
                sQuestion =  "This is Question 4"; //R.array.m1Q1[0];
                sAnswer = "A";
                iImgQuestion = R.drawable.m1q4;
                sAnswer1 = "Answer 1 for Question 4";
                sAnswer2 = "Answer 2 for Question 4";
                sAnswer3 = "Answer 3 for Question 4";
                sAnswer4 = "Answer 4 for Question 4";
                break;

            case 5:
                sQuestion =  "This is Question 5"; //R.array.m1Q1[0];
                sAnswer = "A";
                iImgQuestion = R.drawable.m1q5;
                sAnswer1 = "Answer 1 for Question 5";
                sAnswer2 = "Answer 2 for Question 5";
                sAnswer3 = "Answer 3 for Question 5";
                sAnswer4 = "Answer 4 for Question 5";
                break;
        }
    }

    public String get_sQuestion(){
        return sQuestion;
    }

    public int get_iImgQuestion(){
        return iImgQuestion;
    }

    public String get_sAnswer(){
        return sAnswer;
    }
    public String get_sAnswer1(){
        return sAnswer1;
    }
    public String get_sAnswer2(){
        return sAnswer2;
    }
    public String get_sAnswer3(){
        return sAnswer3;
    }
    public String get_sAnswer4(){
        return sAnswer4;
    }
    public int get_MaxQuestions() { return IMAXQUESTIONS;}
    public int get_CurrentQuestionCounter() {return iCounter;}



}

