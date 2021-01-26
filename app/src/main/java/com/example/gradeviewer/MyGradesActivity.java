package com.example.gradeviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MyGradesActivity extends AppCompatActivity {

    protected TextView gradesTextView;

    protected static ArrayList<Course> courses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_grades);

        setupUI();
        getGrades();
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    public void setupUI(){
        gradesTextView = findViewById(R.id.gradesTextView);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void getGrades(){
        Random rnd = new Random();
        int count = rnd.nextInt(5) + 1;
        count = 5;

        for(int i = 0; i < count; i++){
            double average = 0;
            courses.add(Course.generateRandomCourse());
            ArrayList<Assignment> assignments = courses.get(i).getAssignments();
            gradesTextView.append(courses.get(i).getCourseTitle() + "\n");

            for(int j = 0; j < assignments.size(); j++){
                gradesTextView.append(assignments.get(j).getAssignmentTitle() + " :\t\t" + assignments.get(j).getAssignmentGrade() + "\n");
                average += assignments.get(j).getAssignmentGrade();
            }
            average /= assignments.size();
            average = Math.round(average * 100.0) / 100.0;
            gradesTextView.append("\nAverage :\t\t" + average + "\n\n");
        }
    }

}