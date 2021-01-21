package com.example.gradeviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    protected EditText nameEditText;
    protected EditText ageEditText;
    protected EditText studentIDEditText;
    protected Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        setupUI();

    }

    public void setupUI(){
        nameEditText = findViewById(R.id.nameEditText);
        ageEditText = findViewById(R.id.ageEditText);
        studentIDEditText = findViewById(R.id.studentidEditText);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                saveProfile();
                createToast();
            }
        });
    }

    public void saveProfile(){
        String name = nameEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String studentID = studentIDEditText.getText().toString();

        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.profilekey), Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.profilename), name);
        editor.putString(getString(R.string.profileage), age);
        editor.putString(getString(R.string.profilestudentid), studentID);
        editor.apply();
    }

    public void createToast(){
        Toast toast = Toast.makeText(getApplicationContext(), R.string.savetoast, Toast.LENGTH_LONG);
        toast.show();
    }
}