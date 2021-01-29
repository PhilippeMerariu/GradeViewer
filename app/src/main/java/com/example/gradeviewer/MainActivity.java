package com.example.gradeviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    protected Button showGradesButton;
    protected Button profileButton;

    protected SharedPreferenceHelper sharedPrefHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPrefHelper = new SharedPreferenceHelper(MainActivity.this);

        setupUI();
        checkProfile();
    }


    protected void onStart() {
        super.onStart();

        checkProfile();
    }

    //initialize all the UI objects
    public void setupUI(){
        showGradesButton = findViewById(R.id.showGradesButton);
        profileButton = findViewById(R.id.profileButton);

        showGradesButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                goToMyGrades();
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                goToProfile();
            }
        });
    }

    //Check if a profile already exists.
    //Display profile name on button if exists
    //Navigate to profile activity if doesn't exists
    public void checkProfile(){
        String name = sharedPrefHelper.getProfileName();

        if (name == null){
            goToProfile();
        }else{
            profileButton.setText(name);
        }
    }

    //Navigate to myGrades activity
    public void goToMyGrades(){
        Intent intent = new Intent(this, MyGradesActivity.class);
        startActivity(intent);
    }

    public void goToProfile(){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

}
