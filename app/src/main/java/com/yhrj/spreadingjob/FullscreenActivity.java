package com.yhrj.spreadingjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;

import com.yhrj.spreadingjob.utils.WebViewJavaScriptFunction;
import com.yhrj.spreadingjob.utils.X5WebView;

import java.util.HashMap;

public class FullscreenActivity extends AppCompatActivity {
    X5WebView x5WebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        if (getSupportActionBar() != null) getSupportActionBar().hide();

//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
//                | View.SYSTEM_UI_FLAG_FULLSCREEN
//                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
//                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        x5WebView = findViewById(R.id.webView);
        x5WebView.loadUrl("http://www.haineiedu.com/highway/paving/draw/realtime?deviceCode=0001910230003968&appId=95278888&appSecret=avafdsfdsfdsfdsf32re23");

//        x5WebView.getView().setOverScrollMode(View.OVER_SCROLL_ALWAYS);
        x5WebView.addJavascriptInterface(new WebViewJavaScriptFunction() {
            @Override
            public void onJsFunctionCalled(String tag) {
                // TODO Auto-generated method stub
            }

            @JavascriptInterface
            public void onButtonClicked() {
                FullscreenActivity.this.onButtonClicked();
            }
        }, "Android");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // TODO Auto-generated method stub
        try {
            super.onConfigurationChanged(newConfig);
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //向webView 发出信息
    public void onButtonClicked() {

    }
}
