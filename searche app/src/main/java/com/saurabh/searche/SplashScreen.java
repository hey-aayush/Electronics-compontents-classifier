package com.saurabh.searche;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;
    Animation topanimation,bottomanimation;
    View searchs,es;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);
        topanimation= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomanimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        searchs = findViewById(R.id.search);
        es = findViewById(R.id.e);
        searchs.setAnimation(topanimation);    //setting the top animation to searchs imageview
        es.setAnimation(bottomanimation);      //setting the bottom animation to es imageview
        //Hooks
        //splash screen
        //For animating the image when go to next activity search that it directly get to pasetd in that imageview
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this,Register.class);
                startActivity(i);
                finish();
            }
        },SPLASH_TIME_OUT);

    }
}
