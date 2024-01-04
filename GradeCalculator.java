import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        calculateAndDisplayGrade();
    }

    public static void calculateAndDisplayGrade() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        if (numSubjects <= 0) {
            System.out.println("Invalid number of subjects. Exiting.");
            return;
        }

        int totalMarks = 0;

        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks for Subject " + i + ": ");
            int marks = scanner.nextInt();

            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks. Marks should be between 0 and 100. Exiting.");
                return;
            }

            totalMarks += marks;
        }

        double averagePercentage = (double) totalMarks / numSubjects;

        // Display Results
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage);

        // Grade Calculation
        char grade = calculateGrade(averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    public static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
