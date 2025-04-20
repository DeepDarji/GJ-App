package com.deep.gjapp;

import static com.deep.gjapp.MainActivity2.closeDrawer;
import static com.deep.gjapp.MainActivity2.openDrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class PrivacyPolicy extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_privacy_policy);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        drawerLayout = findViewById(R.id.drawer_activity);
    }

    public void ClickMenu (View view) {
        openDrawer(drawerLayout);
    }


    public void ClickHome(View view) {
        MainActivity2.redirectActivity(this,MainActivity2.class);
    }



    public void ClickAbout(View view) {
        MainActivity2.redirectActivity(this,AboutUs.class);
    }



    public void ClickPrivacy (View view) {
        recreate();
    }



    @Override
    protected void onPause() {
        super.onPause();
        MainActivity2.closeDrawer(drawerLayout);
    }

}