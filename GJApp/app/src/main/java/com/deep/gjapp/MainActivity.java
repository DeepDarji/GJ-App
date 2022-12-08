package com.deep.gjapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ImageView imageView = findViewById(R.id.logo);
        ProgressBar progressBar = findViewById(R.id.progressBar);
        TextView textView = findViewById(R.id.developedBy);

        int splashTimeOut = 3500;
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
            finish();

        }, splashTimeOut);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_animation);
        imageView.startAnimation(animation);
        progressBar.startAnimation(animation);
        textView.startAnimation(animation);
    }
}