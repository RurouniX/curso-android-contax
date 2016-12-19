package com.requestwithlist.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.requestwithlist.R;

public class WebActivity extends AppCompatActivity {

    WebView mWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        mWeb = (WebView) findViewById(R.id.web_nojo);

        WebViewClient wb = new WebViewClient();
        wb.onLoadResource(mWeb, "http://www.google.com");
    }
}
