package com.example.berirohit.testapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
                    if (chkDisclaimer.isChecked()){
                        Log.e("INFORMATION", "chkDisclaimer:" + chkDisclaimer.isChecked());

//                        SharedPreferences sharedPref = disclaimer.this.getPreferences(Context.MODE_PRIVATE);
                        SharedPreferences sharedPref = getSharedPreferences("myDataFile", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putBoolean("DISCLAIMER_ACCEPTED",true);
                        editor.commit();

                        Intent intent = new Intent(disclaimer.this, menu.class);
//                    intent.putExtra("key", "value");
                    disclaimer.this.startActivity(intent);
                }else {
                        Log.e("INFORMATION", "chkDisclaimer:" + chkDisclaimer.isChecked());
                    }

                    Log.e("INFORMATION", "btn ACCEPT Clicked");
//                    Toast.makeText(this,"test", Toast.LENGTH_LONG).show();
                    break;
                case R.id.btnDecline:
                    Log.e("INFORMATION", "btn DECLINE Clicked");
                    CloseFragment();
//                    Intent intent = new Intent(welcome.this, disclaimer.class);
//                    intent.putExtra("key", "value");
//                    welcome.this.startActivity(intent);
                    break;
            }
        }

        private void CloseFragment(){
            Log.e("INFORMATION","Entering function CloseFragment");
//            getActivity().getFragmentManager().beginTransaction().remove(this).commit();
            //getFragmentManager().beginTransaction().remove(disclaimer.class).commit();
        }
    }
}
