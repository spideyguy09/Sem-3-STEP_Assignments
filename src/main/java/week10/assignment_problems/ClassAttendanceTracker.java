package week10.assignment_problems;

import java.util.Arrays;

/**
 * Problem 6: Class Attendance Tracker
 * 
 * TASK:
 * A teacher records attendance for one student as an array of 1s (present) and 0s (absent), one value per
 * day. The teacher wants to know how many days the student was present and the longest run of days the
 * student attended without a break.
 * Implement a function attendanceSummary(days) that returns the number of present days and the
 * length of the longest unbroken run of present days.
 * 
 * CONSTRAINTS:
 * - 1 <= length of days <= 100
 * - Each value is 0 or 1
 * 
 * COMPLEXITY REQUIREMENTS:
 * - Time Complexity: O(n), where n is the number of days.
 *   Both the total present days and the longest streak are calculated in a SINGLE PASS.
 * - Auxiliary Space Complexity: O(1).
 *   Only primitive scalar counters (presentDays, currentStreak, longestStreak) are used.
 * - Single Pass Analysis:
 *   Yes, both answers can be determined simultaneously in a single pass through the array.
 *   As each day is inspected:
 *   - If day == 1: increment total present count, increment current streak, and update maximum streak.
 *   - If day == 0: reset current streak to 0.
 */
public class ClassAttendanceTracker {

    /**
     * Encapsulates the attendance summary result.
     */
    public static class AttendanceResult {
        public final int presentDays;
        public final int longestStreak;

        public AttendanceResult(int presentDays, int longestStreak) {
            this.presentDays = presentDays;
            this.longestStreak = longestStreak;
        }

        @Override
        public String toString() {
            return "Present: " + presentDays + ", Longest streak: " + longestStreak;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof AttendanceResult other)) return false;
            return this.presentDays == other.presentDays && this.longestStreak == other.longestStreak;
        }
    }

    /**
     * Computes the attendance summary in a single pass.
     * 
     * @param days array of 1s (present) and 0s (absent)
     * @return int array [presentDays, longestStreak]
     */
    public static int[] attendanceSummary(int[] days) {
        if (days == null || days.length == 0) {
            return new int[]{0, 0};
        }

        int presentDays = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        // Single pass: O(n) time, O(1) auxiliary space
        for (int day : days) {
            if (day == 1) {
                presentDays++;
                currentStreak++;
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                // Streak resets on absence (day == 0)
                currentStreak = 0;
            }
        }

        return new int[]{presentDays, longestStreak};
    }

    /**
     * Convenience method returning structured AttendanceResult.
     * 
     * @param days array of 1s and 0s
     * @return AttendanceResult object
     */
    public static AttendanceResult getAttendanceSummary(int[] days) {
        int[] res = attendanceSummary(days);
        return new AttendanceResult(res[0], res[1]);
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 6: Class Attendance Tracker ===");

        // Sample 1:
        int[] days1 = {1, 1, 0, 1, 1, 1, 0, 1};
        System.out.println("Sample 1 Days: " + Arrays.toString(days1));
        System.out.println("Output Array : " + Arrays.toString(attendanceSummary(days1)));
        System.out.println("Formatted    : " + getAttendanceSummary(days1));
        System.out.println("Expected     : Present: 6, Longest streak: 3\n");

        // Sample 2:
        int[] days2 = {0, 0, 0};
        System.out.println("Sample 2 Days: " + Arrays.toString(days2));
        System.out.println("Output Array : " + Arrays.toString(attendanceSummary(days2)));
        System.out.println("Formatted    : " + getAttendanceSummary(days2));
        System.out.println("Expected     : Present: 0, Longest streak: 0\n");

        // Additional Case: All present
        int[] days3 = {1, 1, 1, 1, 1};
        System.out.println("Sample 3 (All Present): " + Arrays.toString(days3));
        System.out.println("Formatted    : " + getAttendanceSummary(days3));
        System.out.println("Expected     : Present: 5, Longest streak: 5\n");

        // Additional Case: Alternating
        int[] days4 = {1, 0, 1, 0, 1};
        System.out.println("Sample 4 (Alternating): " + Arrays.toString(days4));
        System.out.println("Formatted    : " + getAttendanceSummary(days4));
        System.out.println("Expected     : Present: 3, Longest streak: 1");
    }
}
