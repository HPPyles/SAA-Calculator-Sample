package saa.calculator.Calculations;

import java.util.ArrayList;

import saa.calculator.Common.GradeInfo;

/*
 * Grade information will be received from syllabus reader or user input, not relevant to this immediate section
 * Grade weighting should always be assumed to be converted to decimal form (double) before being fed into this class
 */

public class Calulating {
    private ArrayList<GradeInfo> grades;
    private int size = 0;
    private boolean weighted = false;
    private double[] weightings;

    public Calulating(ArrayList<GradeInfo> grades) {
        this.grades = new ArrayList<>();
        for (int i = 0; i < grades.size(); i++) {
            this.grades.add(grades.get(i));
            System.err.println("Grade added: " + grades.get(i).getGrade());
        }
        size = grades.size();
        weighted = false;
    }

    public Calulating(ArrayList<GradeInfo> grades, double[] weightings) {
        this.grades = new ArrayList<>();
        for (int i = 0; i < grades.size(); i++) {
            this.grades.add(grades.get(i));            
        }
        size = grades.size();
        weighted = true;
        this.weightings = new double[weightings.length];
        for (int i = 0; i < weightings.length; i++) {
            this.weightings[i] = weightings[i];
        } 
    }
    
    public ArrayList<GradeInfo> getGrades() {
        for (GradeInfo g : grades) {
            System.err.println("Grade" + g.getGrade());
        }
        return grades;
    }

    public boolean addGrade(double totalPts, double earnedPts) {
        if (weighted == false) {
            return addGrade(totalPts, earnedPts, 1);
        }
        return false; // Failure, weight must be included for weighted grades [result handled outside calculator]
    }
    
    /*
     * Option to input weighting will not be provided if weighting hasn't been established
     */
    public boolean addGrade(double totalPts, double earnedPts, double weighting) {
        int initialSize = size;
        double grade = earnedPts/totalPts * 100;

        GradeInfo newGrade;
        if (weighted == false) {
            newGrade = new GradeInfo(totalPts, earnedPts, grade);
        } else {
            newGrade = new GradeInfo(totalPts, earnedPts, grade, weighting);
        }

        grades.add(newGrade);
        size++;

        return (grades.size() - initialSize) == 1;
    }

    public double calculateClassGrade() {
        if (size <= 0) {
            return -1; //Flag for empty grade list, user will receive message such as "Please add your grades."
        }

        double classGrade = 0;

        if (weighted == true) {
            for (double w : weightings) {
                double wEarned = 0;
                double wTotal = 0;
                for (GradeInfo g : grades) {
                    if (g.getWeighting() == w) {
                        wEarned += g.getEarnedPts();
                        wTotal += g.getTotalPts();
                    }
                }
                classGrade += w * (wEarned / wTotal);
            }
        } else {
            double earned = 0;
            double total = 0;
            for (GradeInfo g : grades) {
                earned += g.getEarnedPts();
                total += g.getTotalPts();
            }
            classGrade = earned/total;
        }
        
        return classGrade;
    }
}
