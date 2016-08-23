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

    private String[][] sM1Questions;
    private int[] iM1QuestionImages;


    // these variables relate to the question that is in memory / being displayed on the UI
    private int iQuestion = 0;

    classM1Questions(){
        iCounter = 0;
        Log.i(LOGTYPE, "!!!!!CONSTRUCTOR!!!!!");
        Log.i(LOGTYPE, "function: classM1Questions: " + String.valueOf(iCounter));
        sM1Questions = new String[][] {{"This is Question 1","A","Answer 1 for Question 1","Answer 2 for Question 1","Answer 3 for Question 1","Answer 4 for Question 1"},
                {"This is Question 2","B","Answer 1 for Question 2","Answer 2 for Question 2","Answer 3 for Question 2","Answer 4 for Question 2"},
                {"This is Question 3","B","Answer 1 for Question 3","Answer 2 for Question 3","Answer 3 for Question 3","Answer 4 for Question 3"},
                {"This is Question 4","B","Answer 1 for Question 4","Answer 2 for Question 4","Answer 3 for Question 4","Answer 4 for Question 4"},
                {"This is Question 5","B","Answer 1 for Question 5","Answer 2 for Question 5","Answer 3 for Question 5","Answer 4 for Question 5"}
        };

        iM1QuestionImages = new int[] {R.drawable.m1q1, R.drawable.m1q2, R.drawable.m1q3, R.drawable.m1q4, R.drawable.m1q5};
    }

    void firstQuestion(){
        iCounter = 1;
        Log.i(LOGTYPE, "function: firstQuestion: " + String.valueOf(iCounter));
        readQuestion(iCounter);
    }

    Boolean fnCheckAnswer(String sSelectedAnswer, int iQuesCounter){
        Log.i(LOGTYPE, "function: fnCheckAnswer: " + String.valueOf(iCounter));
        Boolean bIsCorrect = false;

        if (sSelectedAnswer == sM1Questions[iQuesCounter -1][1] ){
            bIsCorrect = true;
        }

        return bIsCorrect;
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

        sQuestion =  sM1Questions[iCount-1][0];
        sAnswer = sM1Questions[iCount-1][1];;
        iImgQuestion = iM1QuestionImages[iCount - 1];
        sAnswer1 = sM1Questions[iCount-1][2];
        sAnswer2 = sM1Questions[iCount-1][3];
        sAnswer3 = sM1Questions[iCount-1][4];
        sAnswer4 = sM1Questions[iCount-1][5];
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

