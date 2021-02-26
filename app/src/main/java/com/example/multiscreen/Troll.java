package com.example.multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class Troll extends AppCompatActivity {
    String search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_troll);

        Button back = (Button) findViewById(R.id.backBtn);
        Button forward = (Button) findViewById(R.id.contBtn);

        Bundle extra = getIntent().getExtras();
        if (extra != null){
            search = extra.getString("SEARCH");
        }

        //Does a websearch in the app for the video
        //https://developer.android.com/guide/webapps/webview
        //https://www.youtube.com/watch?v=TUXui5ItBkM
        //https://www.youtube.com/watch?v=lcfcG31AgyE
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.setWebViewClient(new WebViewClient()); //needed to keep the websearch in the app
        myWebView.getSettings().setJavaScriptEnabled(true); //needed to play the video
        myWebView.loadUrl("https://www.youtube.com/watch?v=dQw4w9WgXcQ"); //Rick Astley - Never Gonna Give You Up

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Troll.this, MainActivity.class);
                startActivity(intent);
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Troll.this, Dictionary.class);
                intent.putExtra("SEARCH",search);
                startActivity(intent);
            }
        });






    }
}