package week6.practice_problems;

/**
 * M1. Student Placement Record Management
 *
 * Encapsulates student placement details into an OOP structure instead of parallel arrays.
 */
public class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;

    /**
     * Constructs a placement record with the specified student name, company, and package.
     *
     * @param studentName name of the student
     * @param company name of the hiring company
     * @param packageLpa package offered in LPA
     */
    public PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    /**
     * Prints one formatted line of the placement record.
     */
    public void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }

    public static void main(String[] args) {
        PlacementRecord[] records = {
            new PlacementRecord("Ravi", "TCS", 4.5),
            new PlacementRecord("Anitha", "Zoho", 6.2),
            new PlacementRecord("Karthik", "Infosys", 4.0)
        };

        for (PlacementRecord record : records) {
            record.printRecord();
        }
    }
}
