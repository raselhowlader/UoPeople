import java.util.ArrayList;
import java.util.Scanner;

// ============================
// Student Class (Instance Level)
// ============================
class Student {

    // Private instance variables (REQUIRED)
    private String name;
    private String id;   // FIXED: now String (not int)
    private int age;
    private String grade;

    // Constructor
    public Student(String name, String id, int age, String grade) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grade = grade;
    }

    // Getter for ID
    public String getId() {
        return id;
    }

    // Get full details
    public String getDetails() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }

    // Update student info
    public void update(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}


// ============================
// StudentManagement Class (Static)
// ============================
class StudentManagement {

    // Private static variables (REQUIRED)
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static int totalStudents = 0;

    // Add Student
    public static void addStudent(String name, String id, int age, String grade) {

        // Validation
        if (id.isEmpty()) {
            System.out.println("❌ Invalid ID!");
            return;
        }

        // Check duplicate ID
        for (Student s : studentList) {
            if (s.getId().equals(id)) {
                System.out.println("❌ Student with this ID already exists!");
                return;
            }
        }

        studentList.add(new Student(name, id, age, grade));
        totalStudents++;
        System.out.println("✅ Student added successfully!");
    }

    // Update Student
    public static void updateStudent(String id, String name, int age, String grade) {

        for (Student s : studentList) {
            if (s.getId().equals(id)) {   // FIXED comparison
                s.update(name, age, grade);
                System.out.println("✅ Student updated successfully!");
                return;
            }
        }

        System.out.println("❌ Error: Student ID not found!");
    }

    // View Students
    public static void viewStudents() {

        if (studentList.isEmpty()) {
            System.out.println("⚠ No students available.");
            return;
        }

        System.out.println("\n--- Student List ---");
        for (Student s : studentList) {
            System.out.println(s.getDetails());
        }

        System.out.println("Total Students: " + totalStudents);
    }
}


// ============================
// Main Class (Administrator Interface)
// ============================
public class StudentSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. View Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            // Input validation
            if (!scanner.hasNextInt()) {
                System.out.println("❌ Invalid input! Enter a number.");
                scanner.next(); // clear invalid input
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // FIXED: clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();  // FIXED

                    System.out.print("Enter Age: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("❌ Invalid age!");
                        scanner.next();
                        break;
                    }
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Grade: ");
                    String grade = scanner.nextLine();

                    StudentManagement.addStudent(name, id, age, grade);
                    break;

                case 2:
                    System.out.print("Enter Student ID to update: ");
                    String updateId = scanner.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter New Age: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("❌ Invalid age!");
                        scanner.next();
                        break;
                    }
                    int newAge = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Grade: ");
                    String newGrade = scanner.nextLine();

                    StudentManagement.updateStudent(updateId, newName, newAge, newGrade);
                    break;

                case 3:
                    StudentManagement.viewStudents();
                    break;

                case 4:
                    System.out.println("✅ Exiting system...");
                    break;

                default:
                    System.out.println("❌ Invalid choice!");
            }

        } while (choice != 4);

        scanner.close();
    }
}