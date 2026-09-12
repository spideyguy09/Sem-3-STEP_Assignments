package week6.practice_problems;

/**
 * M4. Library ID Card Management
 *
 * Demonstrates object reference aliasing vs distinct object allocation in Java.
 */
public class IdCard {
    String name;
    int booksIssued;

    /**
     * Constructs an IdCard with name and number of books issued.
     *
     * @param name cardholder's name
     * @param booksIssued number of books currently issued
     */
    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {
        IdCard ravi = new IdCard("Ravi", 0);
        IdCard duplicate = ravi;
        duplicate.booksIssued = 3;
        IdCard separate = new IdCard("Ravi", 3);

        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}
