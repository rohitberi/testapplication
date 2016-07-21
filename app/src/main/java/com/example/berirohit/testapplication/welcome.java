package com.example.berirohit.testapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class welcome extends AppCompatActivity {

    TextView strWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        strWelcome = (TextView) findViewById(R.id.strWelcome);
        strWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(welcome.this, "Welcome!!!! Welcome!!!! Welcome!!!! Welcome!!!! Welcome!!!! Welcome!!!!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
