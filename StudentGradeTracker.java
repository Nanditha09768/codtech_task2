import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    private ArrayList<Double> grades;
    private Scanner scanner;

    public StudentGradeTracker() {
        grades = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    public void enterGrades() {
        System.out.println("How many grades would you like to enter?");
        int numberOfGrades = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < numberOfGrades; i++) {
            System.out.println("Enter grade for entry " + (i + 1) + ":");
            double grade = scanner.nextDouble();
            grades.add(grade);
            scanner.nextLine(); 
        }
    }

    
    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;
        for (double grade : grades) {
            total += grade;
        }
        return total / grades.size();
    }
    public String determineLetterGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    // Method to calculate GPA (assuming a 4.0 scale where 100-point is scaled to 4.0)
    public double computeGPA(double average) {
        return average / 25; 
    }
    public void showResults() {
        double average = getAverageGrade();
        String letterGrade = determineLetterGrade(average);
        double gpa = computeGPA(average);

        System.out.printf("Average Grade: %.2f\n", average);
        System.out.println("Letter Grade: " + letterGrade);
        System.out.printf("GPA: %.2f\n", gpa);
    }

    
    public static void main(String[] args) {
        StudentGradeTracker tracker = new StudentGradeTracker();
        tracker.enterGrades();
        tracker.showResults();
    }
}
