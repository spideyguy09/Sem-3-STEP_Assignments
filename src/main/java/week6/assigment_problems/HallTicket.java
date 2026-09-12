package week6.assigment_problems;

/**
 * M4. Exam Hall Ticket Reference Management
 *
 * Demonstrates reference aliasing vs distinct object instantiation in Java.
 */
public class HallTicket {
    String studentName;
    int seatNumber;

    /**
     * Constructs a HallTicket with student name and seat number.
     *
     * @param studentName student's name
     * @param seatNumber allocated seat number
     */
    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {
        HallTicket priya = new HallTicket("Priya", 0);
        HallTicket copy = priya;
        copy.seatNumber = 45;
        HallTicket separate = new HallTicket("Priya", 45);

        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));
    }
}
