package com.deep.gjapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class AboutUs extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_about_us);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        drawerLayout = findViewById(R.id.drawer_activity);
    }



    public void ClickHome(View view) {
        MainActivity2.redirectActivity(this,MainActivity2.class);
    }



    public void ClickAbout(View view) {
        recreate();
    }



    public void ClickPrivacy (View view) {
        MainActivity2.redirectActivity(this,PrivacyPolicy.class);
    }



    @Override
    protected void onPause() {
        super.onPause();
        MainActivity2.closeDrawer(drawerLayout);
    }
}