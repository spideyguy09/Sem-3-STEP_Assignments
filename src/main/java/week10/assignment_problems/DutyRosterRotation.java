package week10.assignment_problems;

import java.util.Arrays;

/**
 * Problem 8: Duty Roster Rotation
 * 
 * TASK:
 * A hostel rotates its cleaning duty roster every week by moving each name k places to the right; names
 * that go past the end wrap around to the front.
 * Implement a function rotateRoster(names, k) that returns the roster after rotating it to the right
 * by k places. k may be larger than the number of names.
 * 
 * CONSTRAINTS:
 * - 1 <= length of names <= 100
 * - 0 <= k <= 10^9
 * 
 * COMPLEXITY REQUIREMENTS:
 * - Time Complexity: O(n), where n is the number of names.
 *   By using modulo arithmetic (k % n), we eliminate full cycles in O(1) time and perform
 *   the entire rotation in a single O(n) pass.
 * - Space Complexity:
 *   - Returning a new array: O(n) auxiliary space to hold the rotated result.
 *   - In-place reversal approach: O(1) auxiliary space.
 * 
 * WHY ROTATING ONE PLACE AT A TIME, k TIMES, IS SLOW:
 * - Shifting an array of size n by one position requires moving all n elements, taking O(n) time.
 * - Repeating this single-shift operation k times results in an overall time complexity of O(n * k).
 * - When k can be as large as 10^9 and n = 100, the naive approach requires up to:
 *     n * k = 100 * 10^9 = 10^11 operations!
 *   A standard processor executing ~10^8 operations/second would take over 15 to 20 minutes to complete.
 * - By observing that rotating by n places returns the array to its original state, rotating by k places
 *   is completely equivalent to rotating by (k % n) places.
 *   Since (k % n) < n <= 100, the work drops from 10^11 operations to at most 100 operations,
 *   running in less than a millisecond!
 */
public class DutyRosterRotation {

    /**
     * Rotates the roster to the right by k places and returns a new rotated array.
     * Handles large k (up to 10^9) in O(n) time using k % n.
     * 
     * @param names array of student names on the roster
     * @param k number of places to rotate right
     * @return rotated array of names
     */
    public static String[] rotateRoster(String[] names, int k) {
        if (names == null || names.length <= 1) {
            return names == null ? new String[0] : names.clone();
        }

        int n = names.length;
        // Normalize k: remove full turns
        int effectiveK = (int) (k % n);
        if (effectiveK < 0) {
            effectiveK += n;
        }

        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            // Each name at index i moves to index (i + effectiveK) % n
            rotated[(i + effectiveK) % n] = names[i];
        }

        return rotated;
    }

    /**
     * Overload supporting long k for large inputs.
     * 
     * @param names array of names
     * @param k rotation count as a long
     * @return rotated array
     */
    public static String[] rotateRoster(String[] names, long k) {
        if (names == null || names.length <= 1) {
            return names == null ? new String[0] : names.clone();
        }

        int n = names.length;
        long effectiveK = k % n;
        if (effectiveK < 0) {
            effectiveK += n;
        }

        return rotateRoster(names, (int) effectiveK);
    }

    /**
     * In-place rotation using the 3-step reversal algorithm (O(n) time, O(1) auxiliary space).
     * 1. Reverse entire array.
     * 2. Reverse first k elements.
     * 3. Reverse remaining n - k elements.
     * 
     * @param names array of names to rotate in-place
     * @param k rotation count
     */
    public static void rotateRosterInPlace(String[] names, int k) {
        if (names == null || names.length <= 1) return;
        int n = names.length;
        k = k % n;
        if (k < 0) k += n;
        if (k == 0) return;

        reverse(names, 0, n - 1);
        reverse(names, 0, k - 1);
        reverse(names, k, n - 1);
    }

    private static void reverse(String[] arr, int start, int end) {
        while (start < end) {
            String temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 8: Duty Roster Rotation ===");

        // Sample 1:
        String[] names1 = {"A", "B", "C", "D", "E"};
        int k1 = 2;
        String[] result1 = rotateRoster(names1, k1);
        System.out.println("Sample 1: names = " + Arrays.toString(names1) + ", k = " + k1);
        System.out.println("Result   : " + Arrays.toString(result1));
        System.out.println("Expected : [D, E, A, B, C]\n");

        // Sample 2:
        String[] names2 = {"A", "B", "C", "D", "E"};
        int k2 = 7;
        String[] result2 = rotateRoster(names2, k2);
        System.out.println("Sample 2: names = " + Arrays.toString(names2) + ", k = " + k2);
        System.out.println("Result   : " + Arrays.toString(result2));
        System.out.println("Expected : [D, E, A, B, C] (7 % 5 = 2 places)\n");

        // Large k demonstration: k = 1,000,000,002 (effective shift = 2)
        long largeK = 1_000_000_002L;
        String[] resultLarge = rotateRoster(names1, largeK);
        System.out.println("Large k test: k = 1,000,000,002");
        System.out.println("Result   : " + Arrays.toString(resultLarge));
        System.out.println("Expected : [D, E, A, B, C]\n");

        // In-place rotation verification:
        String[] namesInPlace = {"A", "B", "C", "D", "E"};
        rotateRosterInPlace(namesInPlace, 2);
        System.out.println("In-place Reversal Algorithm Result: " + Arrays.toString(namesInPlace));
        System.out.println("Expected : [D, E, A, B, C]");
    }
}
