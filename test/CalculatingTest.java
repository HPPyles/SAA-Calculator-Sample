package saa.calculator;

import saa.calculator.Calculations.Calulating;
import saa.calculator.Common.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class CalculatingTest 
{

    /*
     * Test case:
     * Create arraylist with grade objects without weighting information.
     * Initialize Calculating class instance with arraylist.
     * Use getGrades to return initialized arraylist and confirm correct number of objects have been initalized.
     */
    @Test
    public void InitializeUnweightedTest() {
        ArrayList<GradeInfo> exampleGrades = new ArrayList<>();
        GradeInfo grade1 = new GradeInfo(100, 82, 0.82);
        exampleGrades.add(grade1);
        System.err.println("Grade added in test: " + grade1.getGrade());
        
        GradeInfo grade2 = new GradeInfo(100, 60, 0.6);
        exampleGrades.add(grade2);
        System.err.println("Grade added in test: " + grade2.getGrade());
        
        GradeInfo grade3 = new GradeInfo(100, 90, 0.9);
        exampleGrades.add(grade3);
        System.err.println("Grade added in test: " + grade3.getGrade());
        
        Calulating calculating = new Calulating(exampleGrades);
        ArrayList<GradeInfo> initGrades = calculating.getGrades();

        assertNotNull(initGrades);
        assertEquals(exampleGrades.size(), initGrades.size());
    }

    /*
     * Test case: Create arraylist with grade objects with weighting information.
     * Create array with all class grade weights
     * Initialize Calculating class instance with arraylist and array.
     * Use getGrades to return initialized arraylist and confirm correct number of objects have been initalized.
     */
    @Test
    public void InitializeWeightedTest() {
        ArrayList<GradeInfo> exampleGrades = new ArrayList<>();
        GradeInfo grade1 = new GradeInfo(100, 82, 0.82, 0.2);
        exampleGrades.add(grade1);
        System.err.println("Grade added in test: " + grade1.getGrade());
        
        GradeInfo grade2 = new GradeInfo(100, 60, 0.6, 0.3);
        exampleGrades.add(grade2);
        System.err.println("Grade added in test: " + grade2.getGrade());
        
        GradeInfo grade3 = new GradeInfo(100, 90, 0.9, 0.5);
        exampleGrades.add(grade3);
        System.err.println("Grade added in test: " + grade3.getGrade());

        double[] weightings = {0.2,0.3,0.5};

        Calulating calculating = new Calulating(exampleGrades, weightings);
        ArrayList<GradeInfo> initGrades = calculating.getGrades();

        assertNotNull(initGrades);
        assertEquals(exampleGrades.size(), initGrades.size());
    }

    /*
     * Test case:
     * Create arraylist with grade objects without weighting information.
     * Initialize Calculating class instance with arraylist.
     * Call addGrade function with information for creating and adding unweighted grade object.
     * Ensure function returns true.
     * Use getGrades to return initialized arraylist and confirm correct number of objects have been initalized.
     */
    @Test
    public void AddUnweightedGradeTest() {
        ArrayList<GradeInfo> exampleGrades = new ArrayList<>();
        GradeInfo grade1 = new GradeInfo(100, 82, 0.82);
        exampleGrades.add(grade1);
        System.err.println("Grade added in test: " + grade1.getGrade());
        
        GradeInfo grade2 = new GradeInfo(100, 60, 0.6);
        exampleGrades.add(grade2);
        System.err.println("Grade added in test: " + grade2.getGrade());
        
        Calulating calculating = new Calulating(exampleGrades);
        boolean addResult = calculating.addGrade(100, 90);

        assertTrue(addResult);
        assertEquals(3, calculating.getGrades().size());
    }

    /*
     * Test case:
     * Create arraylist with grade objects with weighting information.
     * Create array with all class grade weights
     * Initialize Calculating class instance with arraylist and array.
     * Call addGrade function with information for creating and adding weighted grade object.
     * Ensure function returns true.
     * Use getGrades to return initialized arraylist and confirm correct number of objects have been initalized.
     */
    @Test
    public void AddWeightedGradeTest() {
        ArrayList<GradeInfo> exampleGrades = new ArrayList<>();
        GradeInfo grade1 = new GradeInfo(100, 82, 0.82, 0.2);
        exampleGrades.add(grade1);
        System.err.println("Grade added in test: " + grade1.getGrade());
        
        GradeInfo grade2 = new GradeInfo(100, 60, 0.6, 0.3);
        exampleGrades.add(grade2);
        System.err.println("Grade added in test: " + grade2.getGrade());
        
        Calulating calculating = new Calulating(exampleGrades);
        boolean addResult = calculating.addGrade(100, 90, 0.5);

        assertTrue(addResult);
        assertEquals(3, calculating.getGrades().size());
    }
    
    /*
     * Test case:
     * Create arraylist with grade objects without weighting information.
     * Initialize Calculating class instance with arraylist.
     * Call calculateClassGrade and check for expected result.
     */
    @Test
    public void CalculateUnweightedClassGrade() {
        ArrayList<GradeInfo> exampleGrades = new ArrayList<>();
        GradeInfo grade1 = new GradeInfo(100, 82, 0.82);
        exampleGrades.add(grade1);
        System.err.println("Grade added in test: " + grade1.getGrade());
        
        GradeInfo grade2 = new GradeInfo(100, 60, 0.6);
        exampleGrades.add(grade2);
        System.err.println("Grade added in test: " + grade2.getGrade());
        
        GradeInfo grade3 = new GradeInfo(100, 90, 0.9);
        exampleGrades.add(grade3);
        System.err.println("Grade added in test: " + grade3.getGrade());
        
        Calulating calculating = new Calulating(exampleGrades);
        double unweightedClassGrade = calculating.calculateClassGrade();

        assertEquals(0.773, unweightedClassGrade, 0.001);
    }

    /*
     * Test case: Create arraylist with grade objects with weighting information.
     * Create array with all class grade weights
     * Initialize Calculating class instance with arraylist and array.
     * Call calculateClassGrade and check for expected result.
     */
    @Test
    public void CalculateWeightedClassGrade() {
        ArrayList<GradeInfo> exampleGrades = new ArrayList<>();
        GradeInfo grade1 = new GradeInfo(100, 82, 0.82, 0.4);
        exampleGrades.add(grade1);
        System.err.println("Grade added in test: " + grade1.getGrade());
        
        GradeInfo grade2 = new GradeInfo(100, 60, 0.6, 0.4);
        exampleGrades.add(grade2);
        System.err.println("Grade added in test: " + grade2.getGrade());
        
        GradeInfo grade3 = new GradeInfo(100, 90, 0.9, 0.6);
        exampleGrades.add(grade3);
        System.err.println("Grade added in test: " + grade3.getGrade());

        GradeInfo grade4 = new GradeInfo(100, 86, 0.86, 0.6);
        exampleGrades.add(grade4);
        System.err.println("Grade added in test: " + grade3.getGrade());

        double[] weightings = {0.4,0.6};
        
        Calulating calculating = new Calulating(exampleGrades, weightings);
        double unweightedClassGrade = calculating.calculateClassGrade();

        assertEquals(0.812, unweightedClassGrade, 0.0001);
    }
}
