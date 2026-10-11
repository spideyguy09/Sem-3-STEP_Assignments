package week10.assignment_problems;

import java.util.Arrays;

/**
 * Problem 4: Exam Score Band Counter
 * 
 * TASK:
 * A university stores the marks of all students in an exam as an array sorted in ascending order; marks can
 * repeat. Faculty members frequently ask how many students scored within a band [low, high], inclusive of
 * both ends.
 * Implement a function countInBand(scores, low, high) that returns the number of scores s such
 * that low <= s <= high. The array is large and queried very often, so your solution must not scan the
 * scores one by one.
 * 
 * CONSTRAINTS:
 * - 1 <= length of scores <= 10^6
 * - scores is sorted in ascending order
 * - 0 <= low <= high <= 100
 * 
 * COMPLEXITY REQUIREMENTS:
 * - Linear Scan Complexity:
 *   - Time: O(n) per query. For n = 1,000,000 and Q queries, this requires O(Q * n) operations (e.g. 10^9 operations for 1,000 queries), which is far too slow and causes TLE.
 *   - Space: O(1) auxiliary space.
 * 
 * - Optimized Binary Search Solution:
 *   - Time: O(log n) per query. For n = 1,000,000, log2(10^6) is approximately 20 comparisons per query!
 *   - Auxiliary Space: O(1).
 * 
 * DUPLICATES AT EDGES EXPLANATION:
 * - A standard binary search terminates as soon as ANY matching element is encountered.
 * - However, marks frequently repeat at the boundaries of the band:
 *   1. Left boundary (low): If multiple students scored exactly 'low' (e.g. [42, 42]),
 *      a standard binary search could hit the second 42 and miss earlier ones.
 *      To include ALL students with score >= low, we must locate the FIRST position
 *      where scores[i] >= low (Lower Bound).
 *   2. Right boundary (high): If multiple students scored exactly 'high' (e.g. [58, 58, 58]),
 *      a standard binary search might stop at the first or middle 58, excluding the remaining ones.
 *      To include ALL students with score <= high, we must locate the FIRST position
 *      where scores[i] > high (Upper Bound / Strict Upper Bound).
 * - The count of qualifying scores is then given by:
 *      count = upperBound(scores, high) - lowerBound(scores, low).
 */
public class ExamScoreBandCounter {

    /**
     * Finds the first index i such that scores[i] >= target (Lower Bound).
     * If all elements are < target, returns scores.length.
     * 
     * @param scores sorted array of scores
     * @param target lower bound mark
     * @return 0-based first index where scores[i] >= target
     */
    public static int lowerBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] >= target) {
                // Potential answer found, narrow search to the left to find first occurrence
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * Finds the first index i such that scores[i] > target (Upper Bound).
     * If all elements are <= target, returns scores.length.
     * 
     * @param scores sorted array of scores
     * @param target upper bound mark
     * @return 0-based first index where scores[i] > target
     */
    public static int upperBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] > target) {
                // Potential answer found, narrow search to the left to find first occurrence
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * Returns the number of scores s such that low <= s <= high.
     * Operates in O(log n) time using modified binary search (lower & upper bounds).
     * 
     * @param scores sorted array of exam marks
     * @param low lower mark threshold (inclusive)
     * @param high upper mark threshold (inclusive)
     * @return count of scores within the band [low, high]
     */
    public static int countInBand(int[] scores, int low, int high) {
        if (scores == null || scores.length == 0 || low > high) {
            return 0;
        }

        int start = lowerBound(scores, low);
        int end = upperBound(scores, high);

        return Math.max(0, end - start);
    }

    /**
     * Naive linear scan implementation for benchmarking and verification.
     * O(n) time, O(1) space.
     * 
     * @param scores array of scores
     * @param low lower bound
     * @param high upper bound
     * @return count of scores
     */
    public static int countInBandLinear(int[] scores, int low, int high) {
        if (scores == null || low > high) return 0;
        int count = 0;
        for (int s : scores) {
            if (s >= low && s <= high) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: Exam Score Band Counter ===");

        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println("Exam Scores Array: " + Arrays.toString(scores));
        System.out.println("Array Length     : " + scores.length + "\n");

        // Sample 1:
        int low1 = 42, high1 = 58;
        int res1 = countInBand(scores, low1, high1);
        System.out.println("Sample 1: low = " + low1 + ", high = " + high1);
        System.out.println("Binary Search Result : " + res1);
        System.out.println("Linear Scan Result   : " + countInBandLinear(scores, low1, high1));
        System.out.println("Expected             : 6\n");

        // Sample 2:
        int low2 = 90, high2 = 100;
        int res2 = countInBand(scores, low2, high2);
        System.out.println("Sample 2: low = " + low2 + ", high = " + high2);
        System.out.println("Binary Search Result : " + res2);
        System.out.println("Linear Scan Result   : " + countInBandLinear(scores, low2, high2));
        System.out.println("Expected             : 0\n");

        // Sample 3: Entire range
        int low3 = 0, high3 = 100;
        System.out.println("Sample 3: low = " + low3 + ", high = " + high3);
        System.out.println("Result   : " + countInBand(scores, low3, high3));
        System.out.println("Expected : 10\n");

        // Sample 4: Band inside empty gap
        int low4 = 43, high4 = 49;
        System.out.println("Sample 4: low = " + low4 + ", high = " + high4);
        System.out.println("Result   : " + countInBand(scores, low4, high4));
        System.out.println("Expected : 0");
    }
}
