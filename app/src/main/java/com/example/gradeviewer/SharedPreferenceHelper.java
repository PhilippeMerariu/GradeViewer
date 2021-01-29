package com.example.gradeviewer;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceHelper {
    private SharedPreferences sharedPreferences;

    public SharedPreferenceHelper(Context context){
        sharedPreferences = context.getSharedPreferences("profilePreference", Context.MODE_PRIVATE );
    }
    public void saveProfileName(String name){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("profileName", name);
        editor.apply();
    }

    public void saveProfileAge(String age){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("profileAge", age);
        editor.apply();
    }

    public void saveProfileStudentID(String studentID){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("profileStudentID", studentID);
        editor.apply();
    }


    public String getProfileName(){
        return sharedPreferences.getString("profileName", null);
    }

    public String getProfileAge(){
        return sharedPreferences.getString("profileAge", null);
    }

    public String getProfileStudentID(){
        return sharedPreferences.getString("profileStudentID", null);
    }
}
