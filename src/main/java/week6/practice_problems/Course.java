package week6.practice_problems;

/**
 * M3. Course Credit Management
 *
 * Models courses with optional lab credits using constructor chaining via this(...).
 */
public class Course {
    private String code;
    private String title;
    private int credits;
    private int labCredits;

    /**
     * Four-argument constructor setting all fields directly.
     *
     * @param code course code
     * @param title course title
     * @param credits theory credits
     * @param labCredits lab credits
     */
    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    /**
     * Chained constructor for theory-only courses (defaults labCredits to 0).
     *
     * @param code course code
     * @param title course title
     * @param credits theory credits
     */
    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    /**
     * Calculates total credits for the course.
     *
     * @return sum of theory and lab credits
     */
    public int totalCredits() {
        return credits + labCredits;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getCredits() {
        return credits;
    }

    public int getLabCredits() {
        return labCredits;
    }

    public static void main(String[] args) {
        Course theoryCourse = new Course("21CSC201J", "Data Structures", 4);
        Course labCourse = new Course("21CSC205L", "DSA Lab", 3, 1);

        System.out.println(theoryCourse.getCode() + " total credits: " + theoryCourse.totalCredits());
        System.out.println(labCourse.getCode() + " total credits: " + labCourse.totalCredits());
    }
}
