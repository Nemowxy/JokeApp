package com.nemo.joke.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.nemo.joke.R;
import com.nemo.joke.view.TopBar;

/**
 * Created by nemo on 2016/8/2 0002.
 */

public class WebViewGirlActivity extends AppCompatActivity{

    private WebView mWebView;
    private TopBar topBar;
    private String url;
    private String img;
    private String title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_main);
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        img = intent.getStringExtra("img");
        title = intent.getStringExtra("title");
        mWebView = (WebView) findViewById(R.id.web_view);
        topBar = (TopBar) findViewById(R.id.topBar);
        topBar.setTopBarOnclickListener(new TopBar.topBarOnclickListener() {
            @Override
            public void leftClick() {
                finish();
            }

            @Override
            public void rightClick() {
               // showShare();
            }
        });
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                mWebView.loadUrl(url);
                return true;
            }
        });
        mWebView.loadUrl(url);

    }
}
