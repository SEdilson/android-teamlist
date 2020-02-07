package com.example.teamlist;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.teamlist.ui.activity.TeamListActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_splash_screen);
        Handler handleSplashScreen = new Handler();
        handleSplashScreen.postDelayed(new Runnable() {
            @Override
            public void run() {
                initSplashActivity();
            }
        }, 2000);
    }

    private void initSplashActivity() {
        Intent intent = new Intent(this, TeamListActivity.class);
        startActivity(intent);
        finish();
    }
}
