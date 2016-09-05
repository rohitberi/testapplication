package com.example.berirohit.testapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class m2Questions extends AppCompatActivity {

    private final String LOGTYPE = "INFORMATION";
    String strJSONString = "{ questions: [" +
            "{\"Question\":\"This is Question 1\", \"Answer\":\"A\", \"O1\":\"Answer 1 for Question 1\", \"O2\":\"Answer 2 for Question 1\", \"O3\":\"Answer 3 for Question 1\", \"O4\":\"Answer 4 for Question 1\"}," +
            "{\"Question\":\"This is Question 2\", \"Answer\":\"A\", \"O1\":\"Answer 1 for Question 2\", \"O2\":\"Answer 2 for Question 2\", \"O3\":\"Answer 3 for Question 2\", \"O4\":\"Answer 4 for Question 2\"}," +
            "{\"Question\":\"This is Question 3\", \"Answer\":\"A\", \"O1\":\"Answer 1 for Question 3\", \"O2\":\"Answer 2 for Question 3\", \"O3\":\"Answer 3 for Question 3\", \"O4\":\"Answer 4 for Question 3\"}," +
            "{\"Question\":\"This is Question 4\", \"Answer\":\"A\", \"O1\":\"Answer 1 for Question 4\", \"O2\":\"Answer 2 for Question 4\", \"O3\":\"Answer 3 for Question 4\", \"O4\":\"Answer 4 for Question 4\"}," +
            "{\"Question\":\"This is Question 5\", \"Answer\":\"A\", \"O1\":\"Answer 1 for Question 5\", \"O2\":\"Answer 2 for Question 5\", \"O3\":\"Answer 3 for Question 5\", \"O4\":\"Answer 4 for Question 5\"}" +
            "] }";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m2questions);

        Button btnJSONTest = (Button) findViewById(R.id.btnJSONTest);
        btnJSONTest.setOnClickListener(new classButtonClick());

    }

    class classButtonClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Toast.makeText(m2Questions.this,"Test", Toast.LENGTH_LONG).show();

            JSONObject oJSONObj = null;
            try {
                oJSONObj = new JSONObject(strJSONString);
            } catch (JSONException e) {

                Toast.makeText(m2Questions.this,"Error reading JSON String: " + e.getMessage(),Toast.LENGTH_SHORT).show();
                Log.i(LOGTYPE, "Error reading JSON String: " + e.getMessage());
            }

            try {
                JSONArray oJSONArray = oJSONObj.getJSONArray("questions");

                Toast.makeText(m2Questions.this, "JSON Array length: " + String.valueOf(oJSONArray.length()), Toast.LENGTH_SHORT).show();
                Log.i(LOGTYPE, "JSON Array lenght: " + String.valueOf(oJSONArray.length()));

                JSONObject otstObj = new JSONObject();
                for (int iCouunter = 0; iCouunter < oJSONArray.length(); iCouunter++){
                    otstObj = oJSONArray.getJSONObject(iCouunter);
//                    Toast.makeText(m2Questions.this, "Questions : " + otstObj.get("Question").toString(), Toast.LENGTH_LONG).show();
                    Log.i(LOGTYPE, "Questions : " + otstObj.get("Question").toString());
                    Log.i(LOGTYPE, "Answer : " + otstObj.get("Answer").toString());
                    Log.i(LOGTYPE, "1 : " + otstObj.get("O1").toString());
                    Log.i(LOGTYPE, "2 : " + otstObj.get("O2").toString());
                    Log.i(LOGTYPE, "3 : " + otstObj.get("O3").toString());
                    Log.i(LOGTYPE, "4 : " + otstObj.get("O4").toString());
                }

            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(m2Questions.this,"Error reading JSON array: " + e.getMessage(),Toast.LENGTH_SHORT).show();
                Log.i(LOGTYPE, "Error reading JSON array: " + e.getMessage());
            }
        }
    }
}
