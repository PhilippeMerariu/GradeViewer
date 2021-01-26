package com.example.gradeviewer;

import java.util.ArrayList;
import java.util.Random;

public class Course {
    private static int courseID = 0; //static ID increments with every new Course created
    private String courseTitle;
    private ArrayList<Assignment> assignments;

    //Constructor
    private Course(String title, ArrayList<Assignment> assns){
        courseTitle = title;
        assignments = assns;
        courseID++;
    }

    //returns a Course instant with random assignment values
    static public Course generateRandomCourse(){
        Random rnd = new Random();
        int assignmentNo = rnd.nextInt(4) + 1;
        ArrayList<Assignment> tempAssns = new ArrayList<Assignment>();

        for(int i = 0; i < assignmentNo; i++) {
            tempAssns.add(Assignment.generateRandomAssignment());
        }
        return new Course("Course " + courseID, tempAssns);
    }

    // Getters
    public String getCourseTitle(){ return courseTitle; }
    public ArrayList<Assignment> getAssignments(){ return assignments; }
}

