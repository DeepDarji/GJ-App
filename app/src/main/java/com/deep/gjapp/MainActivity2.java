package com.deep.gjapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        drawerLayout = findViewById(R.id.drawer);
    }


    public void ClickMenu (View view) {
        openDrawer(drawerLayout);
    }


    public static void openDrawer(DrawerLayout drawerLayout) {

        drawerLayout.openDrawer(GravityCompat.START);
    }


    public static void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }


    public void ClickHome (View view) {
         recreate();
    }


    public void ClickAbout (View view) {
        redirectActivity(this,AboutUs.class);
    }


    public void ClickAge (View view) {
        redirectActivity(this,AgeCal.class);
    }


    public void ClickCal (View view) {
        redirectActivity(this,Calculator.class);
    }


    public void ClickBrowser (View view) {
        redirectActivity(this,Browser.class);
    }


    public void ClickNotes (View view) {
        redirectActivity(this,Notes.class);
    }


    public void ClickStopwatch (View view) {
        redirectActivity(this,StopwatchActivity.class);
    }


    public void ClickTorch (View view) {
        redirectActivity(this,Torch.class);
    }


    public void ClickGame1 (View view) {
        redirectActivity(this,TicTacToe.class);
    }


    public void ClickPrivacy (View view) {
        redirectActivity(this,PrivacyPolicy.class);
    }


    public void ClickCalendar (View view) {
        redirectActivity(this,Calendar.class);
    }


    public void ClickMore (View view) {
       // redirectActivity(this,Calendar.class);
    }


    public static void redirectActivity(Activity activity,Class Class) {
        Intent intent = new Intent(activity,Class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }


    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}