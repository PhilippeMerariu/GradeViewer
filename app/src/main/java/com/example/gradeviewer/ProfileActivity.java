package com.example.gradeviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.text.TextUtils.isEmpty;

public class ProfileActivity extends AppCompatActivity {

    protected EditText nameEditText;
    protected EditText ageEditText;
    protected EditText studentIDEditText;
    protected Button saveButton;
    protected Button editButton;

    protected SharedPreferenceHelper sharedPrefHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sharedPrefHelper = new SharedPreferenceHelper(ProfileActivity.this);

        setupUI();
        checkProfile();
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    public void setupUI(){
        nameEditText = findViewById(R.id.nameEditText);
        ageEditText = findViewById(R.id.ageEditText);
        studentIDEditText = findViewById(R.id.studentidEditText);
        saveButton = findViewById(R.id.saveButton);
        editButton = findViewById(R.id.editButton);

        saveButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                saveProfile();
            }
        });

        editButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                editMode();
            }
        });

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void saveProfile(){
        String name = nameEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String studentID = studentIDEditText.getText().toString();

        //Validation before save (check if fields are empty)
        if (isEmpty(name)){
            createToast("Error: please enter a Name before saving.");
            return;
        }
        if (isEmpty(age) ){
            createToast("Error: please enter an Age before saving.");
            return;
        }
        if (Integer.parseInt(age) < 18 || Integer.parseInt(age) > 99){
            createToast("Error: please enter a valid age (between 18 and 99).");
            return;
        }
        if (isEmpty(studentID)){
            createToast("Error: please enter a Student ID before saving.");
            return;
        }

        sharedPrefHelper.saveProfileName(name);
        sharedPrefHelper.saveProfileAge(age);
        sharedPrefHelper.saveProfileStudentID(studentID);

        createToast("Profile saved successfully!");
        displayMode();
    }

    public void createToast(String msg){
        Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG);
        toast.show();
    }

    //Check if a profile already exists.
    //Display profile information if exists.
    public void checkProfile(){

        String name = sharedPrefHelper.getProfileName();
        String age = sharedPrefHelper.getProfileAge();
        String studentID = sharedPrefHelper.getProfileStudentID();

        if (name != null){
            nameEditText.setText(name);
            ageEditText.setText(age);
            studentIDEditText.setText(studentID);
            displayMode();
        }else{
            editMode();
        }

    }

    public void displayMode(){
        nameEditText.setEnabled(false);
        ageEditText.setEnabled(false);
        studentIDEditText.setEnabled(false);
        editButton.setEnabled(true);
        saveButton.setEnabled(false);
        //saveButton.setVisibility(View.INVISIBLE);
    }

    public void editMode(){
        nameEditText.setEnabled(true);
        ageEditText.setEnabled(true);
        studentIDEditText.setEnabled(true);
        editButton.setEnabled(false);
        saveButton.setEnabled(true);
        //saveButton.setVisibility(View.VISIBLE);
    }
}