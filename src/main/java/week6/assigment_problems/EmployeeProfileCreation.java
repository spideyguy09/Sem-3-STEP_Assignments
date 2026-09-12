package week6.assigment_problems;

/**
 * M3. Employee Profile Creation Driver
 *
 * Demonstrates creating permanent employees and interns using constructor chaining.
 */
public class EmployeeProfileCreation {
    public static void main(String[] args) {
        Employee permanent = new Employee("E-101", "Divya", 65000);
        Employee intern = new Employee("E-102", "Arjun");

        permanent.printProfile();
        intern.printProfile();
    }
}
