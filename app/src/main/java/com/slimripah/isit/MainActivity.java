package com.slimripah.isit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_TIMER = 5000;

    //variables
    LottieAnimationView splash;
    TextView powered;
    Animation drop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //hooks
        splash = findViewById(R.id.logoImage);
        powered = findViewById(R.id.poweredLine);

        //Animations
        drop = AnimationUtils.loadAnimation(this, R.anim.drop_anim);

        //set animation
        powered.setAnimation(drop);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(getApplicationContext(), SignUp.class);
            startActivity(intent);
            finish();
        }, SPLASH_TIMER);

    }

}