import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private int studentId;
    private String name;
    private String className;

    public Student(int studentId, String name, String className) {
        this.studentId = studentId;
        this.name = name;
        this.className = className;
    }

    // Getter and setter methods here

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + name + ", Class: " + className;
    }
}

class FeeRecord {
    private int recordId;
    private int studentId;
    private double feeAmount;
    private String dueDate;
    private boolean paymentStatus;

    public FeeRecord(int recordId, int studentId, double feeAmount, String dueDate) {
        this.recordId = recordId;
        this.studentId = studentId;
        this.feeAmount = feeAmount;
        this.dueDate = dueDate;
        this.paymentStatus = false;
    }

    // Getter and setter methods here

    @Override
    public String toString() {
        return "Record ID: " + recordId + ", Student ID: " + studentId + ", Fee Amount: " + feeAmount
                + ", Due Date: " + dueDate + ", Payment Status: " + (paymentStatus ? "Paid" : "Unpaid");
    }
}

public class FeesManagementSystem {
    private static List<Student> students = new ArrayList<>();
    private static List<FeeRecord> feeRecords = new ArrayList<>();
    private static int studentIdCounter = 1;
    private static int recordIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Fees Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Add Fee Record");
            System.out.println("3. Display Students");
            System.out.println("4. Display Fee Records");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    addFeeRecord(scanner);
                    break;
                case 3:
                    displayStudents();
                    break;
                case 4:
                    displayFeeRecords();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.next();
        System.out.print("Enter student class: ");
        String className = scanner.next();
        students.add(new Student(studentIdCounter++, name, className));
        System.out.println("Student added successfully.");
    }

    private static void addFeeRecord(Scanner scanner) {
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        System.out.print("Enter fee amount: ");
        double feeAmount = scanner.nextDouble();
        System.out.print("Enter due date (yyyy-mm-dd): ");
        String dueDate = scanner.next();
        feeRecords.add(new FeeRecord(recordIdCounter++, studentId, feeAmount, dueDate));
        System.out.println("Fee record added successfully.");
    }

    private static void displayStudents() {
        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void displayFeeRecords() {
        System.out.println("List of Fee Records:");
        for (FeeRecord feeRecord : feeRecords) {
            System.out.println(feeRecord);
        }
    }
}
