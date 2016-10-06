package com.example.berirohit.testapplication;

import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Arrays;

import java.util.Arrays;

/**
 * Created by roberi on 8/3/'2016.
 *
 * Requirements
 *
 here are some requirements
 - proceed with loading the question in sequence
 - set # of questions answered from total number of question
 - refresh current success percentage (based on correct answers answered)
 - check if this is the first time question is being presented
 - if YES
 check if the question has been answered before
 if NOT
 activate all controls
 If YES
 mark all questions read

 *
 */

public class classM1Questions {
    private int iCounter = 0;
    private int iCountCorrectAnswers = 0;         // this counter to maintain # of correct questions answered
    private Boolean bArrayFirstAttempt[];         // this array tracks weather its the users first attempt at the question or not
    private int iArraySelectedAnswer[];           // this is an array of what was selected as the answer for the question
    private Boolean bArraySelectedAnswerStatus[]; // this array holds whether the selected answer was correct or not

    private final String LOGTYPE = "INFORMATION";
    private final int IMAXQUESTIONS;

    private String sQuestion = "";
    private int iImgQuestion;
    private String sAnswer = "";
    private String sAnswerOption1 = "";
    private String sAnswerOption2 = "";
    private String sAnswerOption3 = "";
    private String sAnswerOption4 = "";
    private int[] iM1QuestionImages;

    JSONArray oJSONQuestionsList;
    JSONObject oJSONInputObject, oJSONQuestion;

    // these variables relate to the question that is in memory / being displayed on the UI
    private int iQuestion = 0;

    classM1Questions() throws JSONException {
        iCounter = 0;
        Log.i(LOGTYPE, "function: !!!!!CONSTRUCTOR!!!!! classM1Questions");

        String sJSONInputString = "{ questions: [" +
                "{\"Question\":\"This is Question 1\", \"Answer\":\"A\", \"O1\":\"Answer 1 for Question 1\", \"O2\":\"Answer 2 for Question 1\", \"O3\":\"Answer 3 for Question 1\", \"O4\":\"Answer 4 for Question 1\"}," +
                "{\"Question\":\"This is Question 2\", \"Answer\":\"B\", \"O1\":\"Answer 1 for Question 2\", \"O2\":\"Answer 2 for Question 2\", \"O3\":\"Answer 3 for Question 2\", \"O4\":\"Answer 4 for Question 2\"}," +
                "{\"Question\":\"This is Question 3\", \"Answer\":\"C\", \"O1\":\"Answer 1 for Question 3\", \"O2\":\"Answer 2 for Question 3\", \"O3\":\"Answer 3 for Question 3\", \"O4\":\"Answer 4 for Question 3\"}," +
                "{\"Question\":\"This is Question 4\", \"Answer\":\"D\", \"O1\":\"Answer 1 for Question 4\", \"O2\":\"Answer 2 for Question 4\", \"O3\":\"Answer 3 for Question 4\", \"O4\":\"Answer 4 for Question 4\"}," +
                "{\"Question\":\"This is Question 5\", \"Answer\":\"B\", \"O1\":\"Answer 1 for Question 5\", \"O2\":\"Answer 2 for Question 5\", \"O3\":\"Answer 3 for Question 5\", \"O4\":\"Answer 4 for Question 5\"}" +
                "] }";
        try {
            oJSONInputObject = new JSONObject(sJSONInputString);
            oJSONQuestionsList = oJSONInputObject.getJSONArray("questions");
        } catch (JSONException e) {
            Log.i(LOGTYPE, "Error reading JSON String: " + e.getMessage());
        }
        iM1QuestionImages = new int[] {R.drawable.m1q1, R.drawable.m1q2, R.drawable.m1q3, R.drawable.m1q4, R.drawable.m1q5};

        IMAXQUESTIONS = oJSONQuestionsList.length();       // set total number of questions based on array length

        bArrayFirstAttempt = new Boolean[IMAXQUESTIONS];            // initialize array
        iArraySelectedAnswer = new int[IMAXQUESTIONS];              // initialize array
        bArraySelectedAnswerStatus = new Boolean[IMAXQUESTIONS];    // initialize array

        iCountCorrectAnswers = 0;
        Arrays.fill(bArrayFirstAttempt,true);           // initialize all array elements to true.
        Arrays.fill(iArraySelectedAnswer,0);            // no answer selected
        Arrays.fill(bArraySelectedAnswerStatus, false); // initialize all Selected answers array to false.
    }

    void fnFirstQuestion(){
        iCounter = 0;
        Log.i(LOGTYPE, "function: firstQuestion: " + String.valueOf(iCounter));
        fnReadQuestion(iCounter);
    }

    Boolean fnCheckAnswer(String sSelectedAnswer, int iQuesCounter){
        Log.i(LOGTYPE, "function: fnCheckAnswer: " + String.valueOf(iCounter));
        Log.i(LOGTYPE, "sSelectedAnswer: " + sSelectedAnswer + " sAnswer: " + sAnswer + " iQuesCounter: " + String.valueOf(iQuesCounter));
        Boolean bIsCorrect = false;
        bArrayFirstAttempt[iQuesCounter] = false;  // irrespective of the answer, the question has been attempted

        switch (sSelectedAnswer){
            case "A":
                iArraySelectedAnswer[iQuesCounter] = 1;
                break;
            case "B":
                iArraySelectedAnswer[iQuesCounter] = 2;
                break;
            case "C":
                iArraySelectedAnswer[iQuesCounter] = 3;
                break;
            case "D":
                iArraySelectedAnswer[iQuesCounter] = 4;
                break;
        }

//        Log.i(LOGTYPE, "bIsCorrect:" + bIsCorrect);
        if  (sSelectedAnswer.compareTo(sAnswer) == 0){  //(sSelectedAnswer == sAnswer){ //sM1Questions[iQuesCounter -1][1] ){
            bIsCorrect = true;
            iCountCorrectAnswers = iCountCorrectAnswers++ ;
            bArraySelectedAnswerStatus[iQuesCounter] = true;    // selected answer is correct
        }else {
            bArraySelectedAnswerStatus[iQuesCounter] = false;   // selected answer is NOT correct
        }
//        Log.i(LOGTYPE, "bIsCorrect:" + bIsCorrect);
        return bIsCorrect;
    }

    Boolean fnNextQuestion(){
        iCounter ++;    // counter starts at 0; before reading next question we move the counter up by 1
        Log.i(LOGTYPE, "function: nextQuestion: " + String.valueOf(iCounter));

        if(iCounter < IMAXQUESTIONS){
            fnReadQuestion(iCounter);
            return true;
        }else{
            iCounter --;  // reset back to last question counter
            Log.i(LOGTYPE, "function: nextQuestion: End of Questions reached");
            return false;
        }
    }

    Boolean fnPreviousQuestion(){
        iCounter --;
        Log.i(LOGTYPE, "function: previousQuestion: " + String.valueOf(iCounter));
        if (iCounter >= 0){
            fnReadQuestion(iCounter);
            return true;
        }else{
            iCounter ++;  // reset back to last question counter
            Log.i(LOGTYPE, "function: previousQuestion: End of Questions reached");
            return false;
        }
    }

    void fnReadQuestion(int iCount){
        // this function will read the contents of a question into memory
        Log.i(LOGTYPE, "function: readQuestion: " + String.valueOf(iCounter));

        try {
            oJSONQuestion = oJSONQuestionsList.getJSONObject(iCount);

            sQuestion =  oJSONQuestion.get("Question").toString(); //sM1Questions[iCount-1][0];
            Log.i(LOGTYPE, "sQuestion: " + sQuestion);
            sAnswer = oJSONQuestion.get("Answer").toString(); //sM1Questions[iCount-1][1];;
            Log.i(LOGTYPE, "sAnswer: " + sAnswer);
            iImgQuestion = iM1QuestionImages[iCount];
            sAnswerOption1 = oJSONQuestion.get("O1").toString(); //ssM1Questions[iCount-1][2];
            sAnswerOption2 = oJSONQuestion.get("O2").toString(); //ssM1Questions[iCount-1][3];
            sAnswerOption3 = oJSONQuestion.get("O3").toString(); //ssM1Questions[iCount-1][4];
            sAnswerOption4 = oJSONQuestion.get("O4").toString(); //ssM1Questions[iCount-1][5];
            Log.i(LOGTYPE, "O1: " + sAnswerOption1);
            Log.i(LOGTYPE, "O2: " + sAnswerOption2);
            Log.i(LOGTYPE, "O3: " + sAnswerOption3);
            Log.i(LOGTYPE, "O4: " + sAnswerOption4);
        }
        catch (JSONException e) {
            e.printStackTrace();
            Log.i(LOGTYPE, "Error reading JSON array: " + e.getMessage());
        }
}
    public String getsQuestion() {
        return sQuestion;
    }
    public int getiImgQuestion(){
        return iImgQuestion;
    }
    public String getsAnswer(){
        return sAnswer;
    }
    public String getsAnswerOption1(){
        return sAnswerOption1;
    }
    public String getsAnswerOption2(){
        return sAnswerOption2;
    }
    public String getsAnswerOption3(){
        return sAnswerOption3;
    }
    public String getsAnswerOption4(){
        return sAnswerOption4;
    }
    public int fnGetMaxQuestions() { return IMAXQUESTIONS; }
    public int fnGetCurrentQuestionCounter() {return iCounter;}
    public int getiCountCorrectAnswers(){return iCountCorrectAnswers;}
    public Boolean getbArrayFirstAttempt(int iCount){
        return bArrayFirstAttempt[iCount];
    }
    public void setbArrayFirstAttempt (int iCount){
        bArrayFirstAttempt[iCount] = false;
    }
    public int getiArraySelectedAnswer(int iCount) { return iArraySelectedAnswer[iCount];}
    public Boolean getbArraySelectedAnswerStatus(int iCount){ return bArraySelectedAnswerStatus[iCount];}
}