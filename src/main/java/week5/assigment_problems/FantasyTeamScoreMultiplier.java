package week5.assigment_problems;

import java.util.Arrays;

public class FantasyTeamScoreMultiplier {

    /**
     * Applies captain (2.0x) and vice-captain (1.5x) multipliers directly
     * to the playerScores array in-place without creating a new array.
     *
     * @param playerScores array of player scores
     * @param captainIndex index of the selected captain
     * @param viceCaptainIndex index of the selected vice-captain
     */
    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (playerScores == null) {
            return;
        }

        if (captainIndex >= 0 && captainIndex < playerScores.length) {
            playerScores[captainIndex] *= 2.0;
        }

        if (viceCaptainIndex >= 0 && viceCaptainIndex < playerScores.length) {
            playerScores[viceCaptainIndex] *= 1.5;
        }
    }

    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        System.out.println("Original scores: " + Arrays.toString(scores));

        applyMultipliers(scores, 1, 3);
        System.out.println("Boosted scores: " + Arrays.toString(scores));
        // Output: [40.0, 110.0, 30.0, 93.0]
    }
}
