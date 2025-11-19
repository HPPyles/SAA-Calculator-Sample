package saa.calculator.Common;

/*
 * Object to hold all grade information
 * - Total points possible
 * - Earned points
 * - Calculated Grade
 * - Weighting if any
 */

public class GradeInfo {
    private double totalPts;
    private double earnedPts;
    private double grade;
    private double weighting;

    public GradeInfo (double totalPts, double earnedPts, double grade, double weighting) {
        this.totalPts = totalPts;
        this.earnedPts = earnedPts;
        this.grade = grade;
        this.weighting = weighting;
    }

    public GradeInfo (double totalPts, double earnedPts, double grade) {
        this.totalPts = totalPts;
        this.earnedPts = earnedPts;
        this.grade = grade;
    }

    public double getTotalPts() { return totalPts; }
    public double getEarnedPts() { return earnedPts; }
    public double getGrade() { return grade; }
    public double getWeighting() { return weighting; }
}
