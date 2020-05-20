package com.saurabh.searche;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Searchwebsite extends AppCompatActivity {
private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchwebsite);
        Intent im = getIntent();
        String keys = im.getStringExtra("key");      //assigning the key passed through intent in a string
        webView = (WebView)findViewById(R.id.webviews);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);   //Enable the javascript code written web application to run

        if(keys.equals("amazon"))                 //comparing the key passed from shop activity and decidt to load url a/c to that
        webView.loadUrl("https://www.amazon.in/");
        else
        if(keys.equals("flipkart"))
            webView.loadUrl("https://www.flipkart.com/");
        else
        if(keys.equals("robu"))
            webView.loadUrl("https://robu.in/");
        webView.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {

        if(webView.canGoBack()){
            webView.goBack();           //through this it will can go back in web pages not directly come to searchwebsite activity
        }
        else
            super.onBackPressed();
    }
}
