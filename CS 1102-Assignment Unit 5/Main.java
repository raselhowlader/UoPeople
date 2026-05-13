import java.util.*;

// Student Class
class Student {

    // Private instance variables
    private String studentName;
    private String studentId;
    private ArrayList<Course> enrolledCourses;
    private HashMap<String, Double> grades;

    // Constructor
    public Student(String studentName, String studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
        enrolledCourses = new ArrayList<>();
        grades = new HashMap<>();
    }

    // Getter methods
    public String getStudentName() {
        return studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public HashMap<String, Double> getGrades() {
        return grades;
    }

    // Setter methods
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    // Enroll student in course
    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
        Course.incrementTotalEnrolledStudents();
        System.out.println("Student enrolled successfully in " + course.getCourseName());
    }

    // Assign grade
    public void assignGrade(Course course, double grade) {
        grades.put(course.getCourseCode(), grade);
        System.out.println("Grade assigned successfully.");
    }
}

// Course Class
class Course {

    // Private instance variables
    private String courseCode;
    private String courseName;
    private int maximumCapacity;

    // Static variable
    private static int totalEnrolledStudents = 0;

    // Constructor
    public Course(String courseCode, String courseName, int maximumCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maximumCapacity = maximumCapacity;
    }

    // Getter methods
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    // Static method
    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }

    // Static method to increase total students
    public static void incrementTotalEnrolledStudents() {
        totalEnrolledStudents++;
    }
}

// CourseManagement Class
class CourseManagement {

    // Private static variables
    private static ArrayList<Course> courseList = new ArrayList<>();
    private static HashMap<String, Double> overallGrades = new HashMap<>();

    // Add course
    public static void addCourse(String code, String name, int capacity) {
        Course course = new Course(code, name, capacity);
        courseList.add(course);
        System.out.println("Course added successfully.");
    }

    // Get all courses
    public static ArrayList<Course> getCourses() {
        return courseList;
    }

    // Enroll student
    public static void enrollStudent(Student student, Course course) {

        if (student.getEnrolledCourses().size() >= course.getMaximumCapacity()) {
            System.out.println("Course maximum capacity reached.");
            return;
        }

        student.enrollCourse(course);
    }

    // Assign grade
    public static void assignGrade(Student student, Course course, double grade) {
        student.assignGrade(course, grade);
    }

    // Calculate overall grade
    public static void calculateOverallGrade(Student student) {

        HashMap<String, Double> grades = student.getGrades();

        if (grades.isEmpty()) {
            System.out.println("No grades available.");
            return;
        }

        double total = 0;

        for (double grade : grades.values()) {
            total += grade;
        }

        double average = total / grades.size();

        overallGrades.put(student.getStudentId(), average);

        System.out.println("Overall Grade Average: " + average);
    }
}

// Main Class
public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {

            System.out.println("\n===== Course Enrollment and Grade Management System =====");
            System.out.println("1. Add Course");
            System.out.println("2. Add Student");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. Assign Grade");
            System.out.println("5. Calculate Overall Grade");
            System.out.println("6. View Total Enrolled Students");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                input.next();
            }

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Course Code: ");
                    String code = input.nextLine();

                    System.out.print("Enter Course Name: ");
                    String cname = input.nextLine();

                    System.out.print("Enter Maximum Capacity: ");
                    int capacity = input.nextInt();
                    input.nextLine();

                    CourseManagement.addCourse(code, cname, capacity);
                    break;

                case 2:

                    System.out.print("Enter Student Name: ");
                    String sname = input.nextLine();

                    System.out.print("Enter Student ID: ");
                    String sid = input.nextLine();

                    Student student = new Student(sname, sid);
                    students.add(student);

                    System.out.println("Student added successfully.");
                    break;

                case 3:

                    if (students.isEmpty() || CourseManagement.getCourses().isEmpty()) {
                        System.out.println("Please add students and courses first.");
                        break;
                    }

                    Student selectedStudent = students.get(0);
                    Course selectedCourse = CourseManagement.getCourses().get(0);

                    CourseManagement.enrollStudent(selectedStudent, selectedCourse);
                    break;

                case 4:

                    if (students.isEmpty() || CourseManagement.getCourses().isEmpty()) {
                        System.out.println("Please add students and courses first.");
                        break;
                    }

                    System.out.print("Enter Grade: ");
                    double grade = input.nextDouble();
                    input.nextLine();

                    CourseManagement.assignGrade(
                            students.get(0),
                            CourseManagement.getCourses().get(0),
                            grade);
                    break;

                case 5:

                    if (students.isEmpty()) {
                        System.out.println("No student available.");
                        break;
                    }

                    CourseManagement.calculateOverallGrade(students.get(0));
                    break;

                case 6:

                    System.out.println("Total Enrolled Students: " +
                            Course.getTotalEnrolledStudents());
                    break;

                case 7:

                    System.out.println("Program exited successfully.");
                    break;

                default:

                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 7);

        input.close();
    }
}
