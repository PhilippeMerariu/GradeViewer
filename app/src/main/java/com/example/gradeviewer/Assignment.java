package com.example.gradeviewer;

import java.util.Random;

public class Assignment {
    private static int assID = 0; //static ID increments with every new assignment created
    private String assignmentTitle; //title of assignment
    private double assignmentGrade; //grade of assignment

    //private constructor. Increments ID.
    private Assignment(String title, double grade){
        assignmentTitle = title;
        assignmentGrade = grade;
        assID++;
    }

    //returns an Assignment instance with random values
    static public Assignment generateRandomAssignment(){
        Random rnd = new Random();
        String tempTitle = "Assignment " + assID;
        double tempGrade = rnd.nextInt(100) + 1;
        return new Assignment(tempTitle, tempGrade);
    }

    // Getters
    public String getAssignmentTitle(){ return assignmentTitle; }
    public double getAssignmentGrade(){ return assignmentGrade; }
}
