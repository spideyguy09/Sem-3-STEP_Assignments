package week6.assigment_problems;

/**
 * M1. Library Inventory Management
 *
 * Encapsulates book inventory details (title, author, copiesAvailable)
 * into an OOP structure instead of parallel arrays.
 */
public class BookInventory {
    String title;
    String author;
    int copiesAvailable;

    /**
     * Constructs a BookInventory record with title, author, and available copies.
     *
     * @param title title of the book
     * @param author author of the book
     * @param copiesAvailable number of available copies
     */
    public BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    /**
     * Prints one formatted entry line.
     */
    public void printEntry() {
        System.out.println(title + " by " + author + " - " + copiesAvailable + " copies available");
    }

    public static void main(String[] args) {
        BookInventory[] books = {
            new BookInventory("Clean Code", "Robert C. Martin", 3),
            new BookInventory("Effective Java", "Joshua Bloch", 5),
            new BookInventory("Refactoring", "Martin Fowler", 0),
            new BookInventory("Design Patterns", "GoF", 2)
        };

        for (BookInventory book : books) {
            book.printEntry();
        }
    }
}
