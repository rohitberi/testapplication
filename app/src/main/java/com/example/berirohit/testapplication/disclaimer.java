package com.example.berirohit.testapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class disclaimer extends AppCompatActivity {

    CheckBox chkDisclaimer;
    Button btnAccept;
    Button btnDecline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_disclaimer);
        setContentView(R.layout.activity_disclaimer);

        chkDisclaimer = (CheckBox) findViewById(R.id.chkDisclaimer);
        btnAccept = (Button) findViewById(R.id.btnAccept);
        btnDecline = (Button) findViewById(R.id.btnDecline);

        btnAccept.setOnClickListener(new OnButtonClick());
        btnDecline.setOnClickListener(new OnButtonClick());
    }

    public class OnButtonClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnAccept:
                    Log.e("INFORMATION", "btn ACCEPT Clicked");
//                    Toast.makeText(this,"test", Toast.LENGTH_LONG).show();
                    break;
                case R.id.btnDecline:
                    Log.e("INFORMATION", "btn DECLINE Clicked");
//                    Toast.makeText(this,"test", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }
}
