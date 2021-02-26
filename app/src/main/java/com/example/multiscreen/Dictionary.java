package com.example.multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class Dictionary extends AppCompatActivity {
    String search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        Button back = (Button) findViewById(R.id.homeBtn);

        Bundle extra = getIntent().getExtras();
        if (extra != null){
            search = extra.getString("SEARCH");
        }

        //Does a websearch in the app for the video
        //https://developer.android.com/guide/webapps/webview
        //https://www.youtube.com/watch?v=TUXui5ItBkM
        WebView myWebView = (WebView) findViewById(R.id.webview2);
        myWebView.setWebViewClient(new WebViewClient()); //needed to keep the websearch in the app
        myWebView.loadUrl("https://www.dictionary.com/browse/"+search);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dictionary.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}