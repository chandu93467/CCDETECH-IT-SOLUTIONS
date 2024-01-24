import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private int[] marks;

    public Student(String name, int rollNumber, int[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public int[] getMarks() {
        return marks;
    }
}

class GradeManagementSystem {
    private Map<Integer, Student> studentMap = new HashMap<>();

    public void addStudent(String name, int rollNumber, int[] marks) {
        studentMap.put(rollNumber, new Student(name, rollNumber, marks));
        System.out.println("Student added successfully.");
    }

    public void updateStudent(int rollNumber, int[] newMarks) {
        if (studentMap.containsKey(rollNumber)) {
            studentMap.put(rollNumber, new Student(studentMap.get(rollNumber).getName(), rollNumber, newMarks));
            System.out.println("Student information updated successfully.");
        } else {
            System.out.println("Student not found with roll number: " + rollNumber);
        }
    }

    public void deleteStudent(int rollNumber) {
        if (studentMap.containsKey(rollNumber)) {
            studentMap.remove(rollNumber);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found with roll number: " + rollNumber);
        }
    }

    public void displayStudentDetails() {
        System.out.println("Student Details:");
        for (Student student : studentMap.values()) {
            System.out.println("Name: " + student.getName());
            System.out.println("Roll Number: " + student.getRollNumber());
            System.out.println("Marks: " + java.util.Arrays.toString(student.getMarks()));
            System.out.println("Overall Percentage: " + calculatePercentage(student.getMarks()) + "%");
            System.out.println("Grade: " + calculateGrade(student.getMarks()));
            System.out.println("--------------------");
        }
    }

    private double calculatePercentage(int[] marks) {
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        return (double) totalMarks / marks.length;
    }

    private String calculateGrade(int[] marks) {
        double percentage = calculatePercentage(marks);

        if (percentage >= 90) {
            return "A";
        } else if (percentage >= 80) {
            return "B";
        } else if (percentage >= 70) {
            return "C";
        } else if (percentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}

public class StudentGradeManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeManagementSystem gradeManagementSystem = new GradeManagementSystem();

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Update Student Information");
            System.out.println("3. Delete Student");
            System.out.println("4. Display Student Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();

                    System.out.print("Enter number of subjects: ");
                    int numSubjects = scanner.nextInt();

                    int[] marks = new int[numSubjects];
                    for (int i = 0; i < numSubjects; i++) {
                        System.out.print("Enter marks for subject " + (i + 1) + ": ");
                        marks[i] = scanner.nextInt();
                    }

                    gradeManagementSystem.addStudent(name, rollNumber, marks);
                    break;

                case 2:
                    System.out.print("Enter roll number to update: ");
                    int updateRollNumber = scanner.nextInt();

                    System.out.print("Enter number of subjects: ");
                    int updateNumSubjects = scanner.nextInt();

                    int[] updateMarks = new int[updateNumSubjects];
                    for (int i = 0; i < updateNumSubjects; i++) {
                        System.out.print("Enter updated marks for subject " + (i + 1) + ": ");
                        updateMarks[i] = scanner.nextInt();
                    }

                    gradeManagementSystem.updateStudent(updateRollNumber, updateMarks);
                    break;

                case 3:
                    System.out.print("Enter roll number to delete: ");
                    int deleteRollNumber = scanner.nextInt();

                    gradeManagementSystem.deleteStudent(deleteRollNumber);
                    break;

                case 4:
                    gradeManagementSystem.displayStudentDetails();
                    break;

                case 5:
                    System.out.println("Exiting the Student Grade Management System. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
