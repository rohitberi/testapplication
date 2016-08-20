package com.example.berirohit.testapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.defaultValue;

public class welcome extends AppCompatActivity {

    TextView strWelcome;
    Boolean DISCLAIMER_ACCEPTED = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        strWelcome = (TextView) findViewById(R.id.strWelcome);
        strWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(welcome.this, "Welcome!!!! Welcome!!!! Welcome!!!!", Toast.LENGTH_SHORT).show();

//                SharedPreferences sharedPref1 = getSharedPreferences("myDataFile", Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPref1.edit();
//                editor.putBoolean("DISCLAIMER_ACCEPTED",false);
//                editor.commit();

                SharedPreferences sharedPref = getSharedPreferences("myDataFile", Context.MODE_PRIVATE);
                DISCLAIMER_ACCEPTED = sharedPref.getBoolean("DISCLAIMER_ACCEPTED",false);

                Toast.makeText(welcome.this, "DISCLAIMER ACCEPTED = " + DISCLAIMER_ACCEPTED, Toast.LENGTH_SHORT).show();

                // if disclaimer was accepted before then skip the disclaimer page and jump to menu page
                Intent intent;
                if (DISCLAIMER_ACCEPTED == true){
                    intent = new Intent(welcome.this, menu.class);
                } else{
                    intent = new Intent(welcome.this, disclaimer.class);
                }
                welcome.this.startActivity(intent);

                // code to retrieve key value pairs from an called Intent
//                Intent intent = getIntent();
//                String value = intent.getStringExtra("key"); //if it's a string you stored.
            }
        });

    }
}
