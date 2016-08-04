package com.example.berirohit.testapplication;

import android.util.Log;

/**
 * Created by roberi on 8/3/2016.
 */

public class classM1Questions {
    private int iCounter = 0;
    private final String LOGTYPE = "INFORMATION";
    private static int iMaxQuestions = 5;

    // these variables relate to the question that is in memory / being displayed on the UI
    private String sAnswer = "";
    private int iQuestion = 0;

    protected void classM1Questions(){
        iCounter = 0;
    }

    void nextQuestion(){
        Log.i(LOGTYPE, "function: nextQuestion: " + String.valueOf(iCounter));

        if(iCounter < iMaxQuestions){
            readQuestion(iCounter);
            iCounter ++;
        }
        Log.i(LOGTYPE, "function: nextQuestion: " + String.valueOf(iCounter));
    }

    void previousQuestion(){

        iCounter --;
        Log.i(LOGTYPE, "function: previousQuestion: " + String.valueOf(iCounter));
    }

    void readQuestion(int iCount){
        // this function will read the contents of a question into memory
    }

}

