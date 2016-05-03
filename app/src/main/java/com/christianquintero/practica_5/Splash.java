package com.christianquintero.practica_5;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {
    private static final long SPLASH_DELAY = 3000;
    private TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //Establesco el modo

        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE); //Quito el actionbar
        setContentView(R.layout.activity_splash);

        titulo = (TextView)findViewById(R.id.titulo);
        Typeface font = Typeface.createFromAsset(getAssets(), "argento.ttf");
        titulo.setTypeface(font);


        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent().setClass(Splash.this, home.class);
                startActivity(i);
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_DELAY);
    }
}
