package week6.assigment_problems;

/**
 * M3 & M5. Employee Class
 *
 * Combines:
 * - M3: Employee Profile Creation (constructor chaining via this(...), printProfile)
 * - M5: Employee and Company Information Management (static companyName and employeeCount, printCompanyInfo)
 */
public class Employee {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    // Static fields shared across all employees (M5)
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    /**
     * Three-argument constructor for permanent employees (M3).
     * Sets isIntern to false and increments total employeeCount (M5).
     *
     * @param empId employee ID
     * @param empName employee name
     * @param salary employee salary
     */
    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
        employeeCount++;
    }

    /**
     * Chained constructor for interns (M3).
     * Uses this(...) to chain to the three-argument constructor with salary set to 0,
     * then sets isIntern to true afterwards.
     *
     * @param empId employee ID
     * @param empName employee name
     */
    public Employee(String empId, String empName) {
        this(empId, empName, 0.0);
        this.isIntern = true;
    }

    /**
     * Two-argument constructor for M5 (empName and salary).
     *
     * @param empName employee name
     * @param salary employee salary
     */
    public Employee(String empName, double salary) {
        this("", empName, salary);
    }

    /**
     * Prints all four fields on one line (M3).
     */
    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }

    /**
     * Static method to print company name and employee count (M5).
     * Does not reference any instance fields.
     */
    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        // M3 Demo
        Employee permanent = new Employee("E-101", "Divya", 65000);
        Employee intern = new Employee("E-102", "Arjun");

        permanent.printProfile();
        intern.printProfile();
    }
}
