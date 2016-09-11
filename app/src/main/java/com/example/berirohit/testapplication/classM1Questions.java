package com.example.berirohit.testapplication;

import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

//    private String[][] sM1Questions;
    private int[] iM1QuestionImages;

    JSONArray oJSONQuestionsList;
    JSONObject oJSONInputObject, oJSONQuestion;

    // these variables relate to the question that is in memory / being displayed on the UI
    private int iQuestion = 0;

    classM1Questions() throws JSONException {
        iCounter = 0;
        Log.i(LOGTYPE, "!!!!!CONSTRUCTOR!!!!!");
        Log.i(LOGTYPE, "function: classM1Questions: " + String.valueOf(iCounter));
//        sM1Questions = new String[][] {{"This is Question 1","A","Answer 1 for Question 1","Answer 2 for Question 1","Answer 3 for Question 1","Answer 4 for Question 1"},
//                {"This is Question 2","B","Answer 1 for Question 2","Answer 2 for Question 2","Answer 3 for Question 2","Answer 4 for Question 2"},
//                {"This is Question 3","B","Answer 1 for Question 3","Answer 2 for Question 3","Answer 3 for Question 3","Answer 4 for Question 3"},
//                {"This is Question 4","B","Answer 1 for Question 4","Answer 2 for Question 4","Answer 3 for Question 4","Answer 4 for Question 4"},
//                {"This is Question 5","B","Answer 1 for Question 5","Answer 2 for Question 5","Answer 3 for Question 5","Answer 4 for Question 5"}
//        };

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
//            Toast.makeText(m1Questions.this,"Error reading JSON String: " + e.getMessage(),Toast.LENGTH_SHORT).show();
            Log.i(LOGTYPE, "Error reading JSON String: " + e.getMessage());
        }
        iM1QuestionImages = new int[] {R.drawable.m1q1, R.drawable.m1q2, R.drawable.m1q3, R.drawable.m1q4, R.drawable.m1q5};
    }

    void firstQuestion(){
        iCounter = 0;
        Log.i(LOGTYPE, "function: firstQuestion: " + String.valueOf(iCounter));
        readQuestion(iCounter);
    }

    Boolean fnCheckAnswer(String sSelectedAnswer, int iQuesCounter){
        Log.i(LOGTYPE, "function: fnCheckAnswer: " + String.valueOf(iCounter));
        Log.i(LOGTYPE, "sSelectedAnswer: " + sSelectedAnswer + " sAnswer: " + sAnswer + " iQuesCounter: " + String.valueOf(iQuesCounter));
        Boolean bIsCorrect = false;

//        Log.i(LOGTYPE, "bIsCorrect:" + bIsCorrect);
        if  (sSelectedAnswer.compareTo(sAnswer) == 0){  //(sSelectedAnswer == sAnswer){ //sM1Questions[iQuesCounter -1][1] ){
            bIsCorrect = true;
        }
//        Log.i(LOGTYPE, "bIsCorrect:" + bIsCorrect);
        return bIsCorrect;
    }

    Boolean nextQuestion(){
        iCounter ++;    // counter starts at 0; before reading next question we move the counter up by 1
        Log.i(LOGTYPE, "function: nextQuestion: " + String.valueOf(iCounter));

        if(iCounter < IMAXQUESTIONS){
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
        if (iCounter >= 0){
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

        try {
            oJSONQuestion = oJSONQuestionsList.getJSONObject(iCount);

            sQuestion =  oJSONQuestion.get("Question").toString(); //sM1Questions[iCount-1][0];
            Log.i(LOGTYPE, "sQuestion: " + sQuestion);
            sAnswer = oJSONQuestion.get("Answer").toString(); //sM1Questions[iCount-1][1];;
            Log.i(LOGTYPE, "sAnswer: " + sAnswer);
            iImgQuestion = iM1QuestionImages[iCount];
            sAnswer1 = oJSONQuestion.get("O1").toString(); //ssM1Questions[iCount-1][2];
            Log.i(LOGTYPE, "O1: " + sAnswer1);
            sAnswer2 = oJSONQuestion.get("O2").toString(); //ssM1Questions[iCount-1][3];
            Log.i(LOGTYPE, "O2: " + sAnswer2);
            sAnswer3 = oJSONQuestion.get("O3").toString(); //ssM1Questions[iCount-1][4];
            Log.i(LOGTYPE, "O3: " + sAnswer3);
            sAnswer4 = oJSONQuestion.get("O4").toString(); //ssM1Questions[iCount-1][5];
            Log.i(LOGTYPE, "O4: " + sAnswer4);
        }
        catch (JSONException e) {
            e.printStackTrace();
            Log.i(LOGTYPE, "Error reading JSON array: " + e.getMessage());
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