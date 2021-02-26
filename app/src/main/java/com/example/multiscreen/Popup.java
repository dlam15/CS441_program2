package com.example.multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Popup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        //Creates a pop up window
        //https://www.youtube.com/watch?v=fn5OlqQuOCk
        DisplayMetrics display = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(display);
        int width = display.widthPixels;
        int height = display.heightPixels;
        getWindow().setLayout((int)(width*.6),(int)(height*.2));
        //This would change the size of the layout and keep it centered
        //To change the x,y position maybe use setAttributes()


        Button enter = (Button) findViewById(R.id.enterBtn);
        EditText search = (EditText) findViewById(R.id.editSearch);

        enter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Popup.this, MainActivity.class);
                String newSearch = search.getText().toString();
                intent.putExtra("SEARCH",newSearch);
                startActivity(intent);
            }
        });
    }
}