package com.ashstudios.safana.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.ashstudios.safana.R;
import com.ashstudios.safana.others.SharedPref;

public class SplashActivity extends AppCompatActivity {
    private Context context;
    private SharedPref sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        context = SplashActivity.this;
        sharedPref = new SharedPref(context);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(sharedPref.getIS_LOGGED_IN()) {
                    //if already login then open the dashboard
                    //check if it is supervisor or worker
                    if(sharedPref.getEMP_ID().contains("SUP")) {
                        Intent intent = new Intent(context,SupervisorDashboard.class);
                        finish();
                        startActivity(intent);
                    }
                    else {
                        Intent intent = new Intent(context,WorkerDashboardActivity.class);
                        finish();
                        startActivity(intent);
                    }
                }
                else {
                    Intent intent = new Intent(context,LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },2000);
    }
}
