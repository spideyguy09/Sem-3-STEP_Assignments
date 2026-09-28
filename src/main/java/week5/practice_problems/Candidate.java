package week5.practice_problems;

/**
 * Represents a candidate in the placement drive.
 * Implements Comparable to rank candidates by composite score descending.
 */
public class Candidate implements Comparable<Candidate> {
    private final String name;
    private final double cgpa;
    private final int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getCodingScore() {
        return codingScore;
    }

    /**
     * Calculates composite score: (cgpa * 10) + (codingScore * 0.5).
     *
     * @return composite score
     */
    public double getCompositeScore() {
        return (this.cgpa * 10.0) + (this.codingScore * 0.5);
    }

    /**
     * Compares candidates in descending order of composite score.
     */
    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }

    @Override
    public String toString() {
        return name + " (" + getCompositeScore() + ")";
    }
}
