package week5.practice_problems;

public class HackathonSeatingGridOptimizer {

    /**
     * Helper method to compute the arithmetic average of a single seating row.
     * Handles jagged rows and null/empty rows safely.
     *
     * @param row array of scores in a single row
     * @return average score of the row, or 0.0 if empty/null
     */
    static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }
        double sum = 0.0;
        for (int score : row) {
            sum += score;
        }
        return sum / row.length;
    }

    /**
     * Classifies each row in a seating grid as "Quiet Zone" or "Buzzing Zone" based on row average.
     *
     * @param seatingScores 2D grid of scores (may be jagged)
     * @param threshold score threshold separating Quiet from Buzzing
     * @return formatted classification string across all rows
     */
    public static String classifyRows(int[][] seatingScores, int threshold) {
        if (seatingScores == null || seatingScores.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String zone = (avg >= threshold) ? "Buzzing Zone" : "Quiet Zone";

            if (i > 0) {
                result.append(" | ");
            }
            result.append("Row ").append(i).append(": ").append(zone);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] seatingScores = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        int threshold = 60;

        System.out.println(classifyRows(seatingScores, threshold));
        // Output: Row 0: Quiet Zone | Row 1: Buzzing Zone | Row 2: Quiet Zone
    }
}
