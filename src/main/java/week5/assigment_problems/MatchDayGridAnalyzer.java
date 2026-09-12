package week5.assigment_problems;

public class MatchDayGridAnalyzer {

    /**
     * Helper method to compute the average runs per over in a single match.
     * Safely handles jagged rows and empty arrays.
     *
     * @param row array representing runs conceded/scored in each over of the match
     * @return average runs per over, or 0.0 if empty
     */
    static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }

        double sum = 0.0;
        for (int runs : row) {
            sum += runs;
        }
        return sum / row.length;
    }

    /**
     * Classifies each match as "Power Surge" or "Normal" based on average runs per over.
     *
     * @param runsPerOver 2D grid where each row represents a match (possibly varying overs)
     * @param threshold score threshold to qualify as Power Surge
     * @return formatted classification string across all matches
     */
    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        if (runsPerOver == null || runsPerOver.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String status = (avg >= threshold) ? "Power Surge" : "Normal";

            if (i > 0) {
                result.append(" | ");
            }
            result.append("Match ").append(i).append(": ").append(status);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] runsPerOver = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        int threshold = 8;

        System.out.println(classifyMatches(runsPerOver, threshold));
        // Output: Match 0: Normal | Match 1: Power Surge | Match 2: Normal
    }
}
