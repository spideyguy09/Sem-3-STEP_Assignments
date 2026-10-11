package week10.assignment_problems;

import java.util.Arrays;

/**
 * Problem 7: Second-Best Score
 * 
 * TASK:
 * A quiz app stores the scores of all players in an array. Prizes go to the top two different scores, so the app
 * needs the second-highest distinct score. If every player has the same score, there is no second-highest
 * score.
 * Implement a function secondHighest(scores) that returns the second-highest distinct score, or -1 if
 * it does not exist.
 * 
 * CONSTRAINTS:
 * - 1 <= length of scores <= 1000
 * - 0 <= scores[i] <= 100
 * - Do not sort the array
 * 
 * COMPLEXITY REQUIREMENTS & COMPARISON WITH SORTING:
 * 
 * 1. Single-Pass Linear Scan (Required Solution):
 *    - Time Complexity: O(n), where n is the length of scores.
 *      Each score is visited exactly once in a single pass.
 *    - Space Complexity: O(1) auxiliary space.
 *      Only two integer variables (highest, second) are retained.
 * 
 * 2. Comparison with Sorting First:
 *    - If the array were sorted first (e.g. Arrays.sort(scores)):
 *      - Time Complexity: O(n log n) due to the sorting step.
 *      - Space Complexity: O(log n) to O(n) auxiliary space depending on the sorting algorithm
 *        (e.g., dual-pivot Quicksort / Timsort recursion stack or buffer).
 *      - Furthermore, sorting mutates the original order of the input array (or requires an O(n) clone)
 *        and explicitly violates the constraint: "Do not sort the array".
 *    - In contrast, the single-pass solution runs in linear O(n) time, uses strictly O(1) auxiliary space,
 *      does not alter the input array, and is optimal.
 */
public class SecondBestScore {

    /**
     * Finds the second-highest distinct score without sorting.
     * 
     * @param scores array of player scores (0 <= scores[i] <= 100)
     * @return second-highest distinct score, or -1 if none exists
     */
    public static int secondHighest(int[] scores) {
        if (scores == null || scores.length < 2) {
            return -1;
        }

        int highest = -1;
        int second = -1;

        // Single pass through scores: O(n) time, O(1) space
        for (int score : scores) {
            if (score > highest) {
                // Current score beats the highest; previous highest drops to second
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                // Current score is strictly between highest and second
                second = score;
            }
            // If score == highest or score <= second, it is skipped
        }

        return second;
    }

    /**
     * Alternative demonstration using sorting (for complexity comparison only).
     * Time: O(n log n), Space: O(n).
     * 
     * @param scores array of scores
     * @return second-highest distinct score
     */
    public static int secondHighestWithSorting(int[] scores) {
        if (scores == null || scores.length < 2) return -1;
        int[] copy = scores.clone();
        Arrays.sort(copy);

        int max = copy[copy.length - 1];
        for (int i = copy.length - 2; i >= 0; i--) {
            if (copy[i] < max) {
                return copy[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 7: Second-Best Score ===");

        // Sample 1:
        int[] scores1 = {45, 78, 92, 78, 60};
        System.out.println("Sample 1 Scores: " + Arrays.toString(scores1));
        System.out.println("Result (O(n))  : " + secondHighest(scores1));
        System.out.println("Expected       : 78\n");

        // Sample 2:
        int[] scores2 = {50, 50, 50};
        System.out.println("Sample 2 Scores: " + Arrays.toString(scores2));
        System.out.println("Result (O(n))  : " + secondHighest(scores2));
        System.out.println("Expected       : -1\n");

        // Edge Case 3: Duplicate maximum scores
        int[] scores3 = {95, 95, 80, 70};
        System.out.println("Sample 3 (Duplicate Max) Scores: " + Arrays.toString(scores3));
        System.out.println("Result (O(n))  : " + secondHighest(scores3));
        System.out.println("Expected       : 80\n");

        // Edge Case 4: Single element
        int[] scores4 = {100};
        System.out.println("Sample 4 (Single Element): " + Arrays.toString(scores4));
        System.out.println("Result (O(n))  : " + secondHighest(scores4));
        System.out.println("Expected       : -1\n");

        // Edge Case 5: Minimum valid scores
        int[] scores5 = {0, 5};
        System.out.println("Sample 5 (0 and 5): " + Arrays.toString(scores5));
        System.out.println("Result (O(n))  : " + secondHighest(scores5));
        System.out.println("Expected       : 0");
    }
}
