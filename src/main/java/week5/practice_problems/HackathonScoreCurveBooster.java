package week5.practice_problems;

import java.util.Arrays;

public class HackathonScoreCurveBooster {

    /**
     * Curves scores in place by adding a flat bonus to each element.
     * Modifies the caller's original array directly without returning anything.
     *
     * @param scores array of team scores
     * @param bonus non-negative integer bonus
     */
    public static void curveScores(int[] scores, int bonus) {
        if (scores == null) {
            return;
        }
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        int[] scores = {70, 85, 60};
        System.out.println("Original scores: " + Arrays.toString(scores));

        curveScores(scores, 10);

        // Printing leaderboard using standard library helper Arrays.toString
        System.out.println("Curved scores: " + Arrays.toString(scores));
    }
}
