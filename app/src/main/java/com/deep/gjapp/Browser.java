package com.deep.gjapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;


public class Browser extends Activity {
    EditText urlBox;
    WebView webView;
    Button back,forward,refresh,cancel;
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_browser);

        urlBox = (EditText)findViewById(R.id.urlBox);
        webView = (WebView)findViewById(R.id.webView);
        back = (Button)findViewById(R.id.back);
        forward = (Button)findViewById(R.id.forward);
        refresh = (Button)findViewById(R.id.refresh);
        progress = (ProgressBar)findViewById(R.id.progress);

        webView.setWebViewClient(new CustomWebViewClient());
        webView.setWebChromeClient(new CustomWebChromeClient());

        urlBox.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //when enter is pressed in edittext, start loading the page
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    webView.loadUrl(urlBox.getText().toString());
                    return true;
                }
                return false;
            }
        });

        //go to previous page
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(webView.canGoBack()){
                    webView.goBack();
                }
            }
        });

        //go to next page
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(webView.canGoForward()){
                    webView.goForward();
                }
            }
        });

        //reload page
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.reload();
            }
        });

    }


    public class CustomWebViewClient extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    public class CustomWebChromeClient extends WebChromeClient{
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            progress.setProgress(newProgress);
            urlBox.setText(view.getUrl());

            if (newProgress == 100) {
                cancel.setVisibility(View.GONE);
                progress.setVisibility(View.GONE);


            } else {
                cancel.setVisibility(View.VISIBLE);
                progress.setVisibility(View.VISIBLE);

            }
        }
    }
}