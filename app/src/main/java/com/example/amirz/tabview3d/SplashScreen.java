package com.example.amirz.tabview3d;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by amirz on 2/13/2018.
 */

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread mThread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(1000);
                    Intent mIntent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(mIntent);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        mThread.start();


    }
}
