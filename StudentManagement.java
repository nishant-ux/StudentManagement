import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }
    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}

public class StudentManagement {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("\n--- Student Record Management System ---");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine(); 

                switch (choice) {
                    case 1 -> addStudent();
                    case 2 -> viewStudents();
                    case 3 -> updateStudent();
                    case 4 -> deleteStudent();
                    case 5 -> {
                        System.out.println("Exiting... Thank you!");
                        return;
                    }
                    default -> System.out.println(" Invalid choice! Please select 1-5.");
                }
            } catch (InputMismatchException e) {
                System.out.println(" Invalid input! Please enter a number.");
                sc.nextLine();
            }
        }
    }

    private static void addStudent() {
        try {
            System.out.print("Enter Student ID (integer): ");
            int id = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Marks (0-100): ");
            double marks = sc.nextDouble();

            if (marks < 0 || marks > 100) {
                System.out.println(" Marks must be between 0 and 100!");
                return;
            }

            students.add(new Student(id, name, marks));
            System.out.println(" Student added successfully!");
        } catch (InputMismatchException e) {
            System.out.println(" Invalid input type! Please enter correct values.");
            sc.nextLine(); 
        }
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println(" No records found!");
        } else {
            System.out.println("\n--- Student Records ---");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    private static void updateStudent() {
        try {
            System.out.print("Enter Student ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();

            for (Student s : students) {
                if (s.getId() == id) {
                    System.out.print("Enter new name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter new marks (0-100): ");
                    double marks = sc.nextDouble();

                    if (marks < 0 || marks > 100) {
                        System.out.println(" Marks must be between 0 and 100!");
                        return;
                    }

                    s.setName(name);
                    s.setMarks(marks);

                    System.out.println(" Student updated successfully!");
                    return;
                }
            }
            System.out.println(" Student not found!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter correct data.");
            sc.nextLine(); 
        }
    }

    private static void deleteStudent() {
        try {
            System.out.print("Enter Student ID to delete: ");
            int id = sc.nextInt();

            for (Student s : students) {
                if (s.getId() == id) {
                    students.remove(s);
                    System.out.println("Student deleted successfully!");
                    return;
                }
            }
            System.out.println(" Student not found!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid ID.");
            sc.nextLine(); 
        }
    }
}

