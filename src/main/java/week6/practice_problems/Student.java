package week6.practice_problems;

/**
 * M5. Student and College Information Management
 *
 * Demonstrates the use of static fields and static methods shared across all instances.
 */
public class Student {
    String name;
    double attendance;

    // Static fields shared by every student
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    /**
     * Constructs a Student object and increments the shared student counter.
     *
     * @param name student name
     * @param attendance student attendance percentage
     */
    public Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    /**
     * Static method to print college information and total student count.
     * Does not reference any instance fields.
     */
    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        // Create two Student objects
        new Student("Ravi", 85.0);
        new Student("Anitha", 92.0);

        System.out.println("2 Student objects created\n");

        // Call printCollegeInfo through the class name, not through either object
        Student.printCollegeInfo();
    }
}
