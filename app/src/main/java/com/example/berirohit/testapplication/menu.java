package com.example.berirohit.testapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class menu extends AppCompatActivity {

    Button btnMenuOption1;
    Button btnMenuOption2;
    Button btnMenuOption3;
    Button btnMenuOption4;
    Button btnMenuOption5;
    Button btnMenuOption6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_disclaimer);
        setContentView(R.layout.activity_menu);

        btnMenuOption1 = (Button) findViewById(R.id.btnMenuOption1);
        btnMenuOption2 = (Button) findViewById(R.id.btnMenuOption2);
        btnMenuOption3 = (Button) findViewById(R.id.btnMenuOption3);
        btnMenuOption4 = (Button) findViewById(R.id.btnMenuOption4);
        btnMenuOption5 = (Button) findViewById(R.id.btnMenuOption5);
        btnMenuOption6 = (Button) findViewById(R.id.btnMenuOption6);

        btnMenuOption1.setOnClickListener(new menuButtonClick());
        btnMenuOption2.setOnClickListener(new menuButtonClick());
        btnMenuOption3.setOnClickListener(new menuButtonClick());
        btnMenuOption4.setOnClickListener(new menuButtonClick());
        btnMenuOption5.setOnClickListener(new menuButtonClick());
        btnMenuOption6.setOnClickListener(new menuButtonClick());
    }

    public class menuButtonClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent;
            switch (view.getId()){
                case R.id.btnMenuOption1:
                    Log.e("INFORMATION", "Menu Option 1 Clicked");
                    intent = new Intent(menu.this, m1questions.class);
                    menu.this.startActivity(intent);
                    break;

                case R.id.btnMenuOption2:
                    Log.e("INFORMATION", "Menu Option 2 Clicked");
                    intent = new Intent(menu.this, m2Questions.class);
                    menu.this.startActivity(intent);
                    break;

                case R.id.btnMenuOption3:
                    Log.e("INFORMATION", "Menu Option 3 Clicked");
//                    intent = new Intent(menu.this, m2questions.class);
//                    intent.putExtra("key", "value");
//                    menu.this.startActivity(intent);
                    break;

                case R.id.btnMenuOption4:
                    Log.e("INFORMATION", "Menu Option 4 Clicked");
//                    intent = new Intent(menu.this, m2questions.class);
//                    intent.putExtra("key", "value");
//                    menu.this.startActivity(intent);
                    break;

                case R.id.btnMenuOption5:
                    Log.e("INFORMATION", "Menu Option 5 Clicked");
//                    intent = new Intent(menu.this, m2questions.class);
//                    intent.putExtra("key", "value");
//                    menu.this.startActivity(intent);
                    break;

                case R.id.btnMenuOption6:
                    Log.e("INFORMATION", "Menu Option 6 Clicked");
//                    intent = new Intent(menu.this, m2questions.class);
//                    intent.putExtra("key", "value");
//                    menu.this.startActivity(intent);
                    break;
            }

        }
    }

}
