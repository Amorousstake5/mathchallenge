package com.uxp.math;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webview);
        setupWebView();
        webView.loadUrl("file:///android_asset/index.html");

        EdgeToEdge.enable(this);
    }
    private void setupWebView(){
        WebSettings webSettings = webView.getSettings();
        //Enabling JS
        webSettings.setJavaScriptEnabled(true);
        //Enabling DOM storage
        webSettings.setDomStorageEnabled(true);
        //Enabling local storage
        webSettings.setDatabaseEnabled(true);
        //File Access
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);
        //Cache
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        //Setting WebView client for loading the page
        webView.setWebViewClient(new WebViewClient( ) {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //URL loading
                if (url.startsWith("file://")){
                    view.loadUrl(url);
                    return true;
                }
                return false;
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();

        }
        else{
            super.onBackPressed();
        }
    }

}