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

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl("https://www.youtube.com/watch?v=dQw4w9WgXcQ");

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