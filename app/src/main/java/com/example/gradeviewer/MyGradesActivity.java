package com.example.gradeviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MyGradesActivity extends AppCompatActivity {

    protected TextView gradesTextView;
    protected Button convertGradesButton;

    protected static ArrayList<Course> courses = new ArrayList<>();
    protected static boolean isLetter = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_grades);

        setupUI();
        getGrades();
        isLetter = false;
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    public void setupUI(){
        gradesTextView = findViewById(R.id.gradesTextView);
        convertGradesButton = findViewById(R.id.convertGradesButton);

        convertGradesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                convertGrades();
            }
        });

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void getGrades(){
        Random rnd = new Random();
        int count = rnd.nextInt(5) + 1;

        courses.clear();
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

    public void convertGrades(){
        double average = 0;
        double nbAssignments = 0;

        gradesTextView.setText("");
        for(Course course : courses){
            average = 0;
            nbAssignments = 0;
            gradesTextView.append(course.getCourseTitle() + "\n");
            for(Assignment assignment : course.getAssignments()){
                gradesTextView.append(assignment.getAssignmentTitle() + " :\t\t" + displayGrade(assignment.getAssignmentGrade()) + "\n");
                average += assignment.getAssignmentGrade();
                nbAssignments++;
            }
            average /= nbAssignments;
            average = Math.round(average * 100.0) / 100.0;
            gradesTextView.append("\nAverage : \t\t" + displayGrade(average) + "\n\n");
        }
        isLetter = !isLetter;
    }

    public String displayGrade(double grade){
        if (isLetter){
            return String.valueOf(grade);
        }
        if(grade >= 90){
            return "A+";
        }
        if(grade >= 85){
            return "A";
        }
        if(grade >= 80){
            return "A-";
        }
        if(grade >= 77){
            return "B+";
        }
        if(grade >= 73){
            return "B";
        }
        if(grade >= 70){
            return "B-";
        }
        if(grade >= 67){
            return "C+";
        }
        if(grade >= 63){
            return "C";
        }
        if(grade >= 60){
            return "C-";
        }
        if(grade >= 57){
            return "D+";
        }
        if(grade >= 53){
            return "D";
        }
        if(grade >= 50){
            return "D-";
        }
        return "F";
    }


}