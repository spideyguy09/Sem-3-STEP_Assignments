package week6.assigment_problems;

/**
 * M5. Employee and Company Information Management Driver
 *
 * Demonstrates static company information and employee tracking across multiple objects.
 */
public class EmployeeCompanyInformationManagement {
    public static void main(String[] args) {
        // Reset count for isolated demonstration
        Employee.employeeCount = 0;

        // Create three Employee objects
        new Employee("Divya", 65000);
        new Employee("Arjun", 0);
        new Employee("Varun", 50000);

        System.out.println("3 Employee objects created\n");

        // Call printCompanyInfo through the class name, not through any object
        Employee.printCompanyInfo();
    }
}
