package com.nemo.joke.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.nemo.joke.R;
import com.nemo.joke.onekeyshare.OnekeyShare;
import com.nemo.joke.view.TopBar;

import cn.sharesdk.framework.ShareSDK;

/**
 * Created by nemo on 2016/8/2 0002.
 */

public class WebViewActivity extends AppCompatActivity{

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
        WebSettings setting = mWebView.getSettings();
        setSettings(setting);
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl(url);
//        mWebView.setWebChromeClient(new WebChromeClient(){
//            @Override
//            public void onShowCustomView(View view, CustomViewCallback callback) {
//                if (myCallback != null) {
//                    myCallback.onCustomViewHidden();
//                    myCallback = null ;
//                    return;
//                }
//
//                long id = Thread.currentThread().getId();
//
//                ViewGroup parent = (ViewGroup) mWebView.getParent();
//                String s = parent.getClass().getName();
//                parent.removeView( mWebView);
//                parent.addView(view);
//                myView = view;
//                myCallback = callback;
//            }
//
//            private View myView = null;
//            private CustomViewCallback myCallback = null;
//
//
//            public void onHideCustomView() {
//
//                long id = Thread.currentThread().getId();
//                if (myView != null) {
//
//                    if (myCallback != null) {
//                        myCallback.onCustomViewHidden();
//                        myCallback = null ;
//                    }
//
//                    ViewGroup parent = (ViewGroup) myView.getParent();
//                    parent.removeView( myView);
//                    parent.addView( mWebView);
//                    myView = null;
//                }
//            }
//        });

    }

    private void setSettings(WebSettings setting) {
        setting.setJavaScriptEnabled(true);
        setting.setBuiltInZoomControls(true);
        setting.setDisplayZoomControls(false);
        setting.setSupportZoom(true);

        setting.setDomStorageEnabled(true);
        setting.setDatabaseEnabled(true);
        // 全屏显示
        setting.setLoadWithOverviewMode(true);
        setting.setUseWideViewPort(true);
    }
    private void showShare() {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle(getString(R.string.ssdk_oks_share));
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText(title);
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl(img);
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(url);
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
       // oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://gank.io");

// 启动分享GUI
        oks.show(this);
    }
}
