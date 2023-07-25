package com.slimripah.isit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    //variables
    TextInputLayout phone, atname;
    Button cheers;

    LottieAnimationView lottie;
    Animation drop;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //hooks
        lottie = findViewById(R.id.lottie);
        phone = findViewById(R.id.phone);
        atname = findViewById(R.id.username);
        cheers = findViewById(R.id.button);

        //animations
        drop = AnimationUtils.loadAnimation(this, R.anim.drop_anim);

        //on button click
        cheers.setOnClickListener(v -> {

            rootNode = FirebaseDatabase.getInstance();
            reference = rootNode.getReference("users");

            //get values from text fields
            String phoneNo = phone.getEditText().getText().toString();
            String username = atname.getEditText().getText().toString();

            //save data to firebase real time firebase
            UserHelperClass helperClass = new UserHelperClass(phoneNo, username);
            reference.child(phoneNo).setValue(helperClass);

            // Start the Dashboard activity
            Intent intent = new Intent(SignUp.this, Dashboard.class);
            startActivity(intent);

        });

    }
}