package com.example.capconnect20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
    }

    public void visitWeb(View view) {
        WebView webview = new WebView(this);
        setContentView(webview);
        webview.loadUrl("http://capconnectonline.org");
    }
}