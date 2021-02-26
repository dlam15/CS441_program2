package com.example.multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    String search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button popup = (Button) findViewById(R.id.popupBtn);
        Button next = (Button) findViewById(R.id.goBtn);
        TextView line = (TextView) findViewById(R.id.inputText);

        Bundle extra = getIntent().getExtras();
        if (extra == null){
            //disable button
            //https://stackoverflow.com/questions/5019857/how-to-set-a-button-gray-and-unclickable
            next.setEnabled(false);
            next.setBackgroundColor(0xFFAFA8A0);
        }else{
            //Pass values between activities
            //https://stackoverflow.com/questions/2091465/how-do-i-pass-data-between-activities-in-android-application
            search = extra.getString("SEARCH");
            next.setEnabled(true);
            line.setText(search);
            next.setBackgroundColor(0xFFE3A452);
        }


        popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Popup.class);
                startActivity(intent);
            }
        });

        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Random rand = new Random();
                int choice = rand.nextInt(3);
                if (choice ==0) {
                    Intent intent = new Intent(MainActivity.this, Troll.class);
                    intent.putExtra("SEARCH", search);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(MainActivity.this, Dictionary.class);
                    intent.putExtra("SEARCH", search);
                    startActivity(intent);
                }
            }
        });

    }
}