package week10.assignment_problems;

import java.util.Arrays;

/**
 * Problem 10: Busiest Bus Row
 * 
 * TASK:
 * A college bus records how many students sit in each seat as a 2D grid, where each row is one row of
 * seats. The transport office wants to know which row carries the most students.
 * Implement a function busiestRow(grid) that returns the index of the row with the largest total and
 * that total. If two rows tie, return the one with the smaller index.
 * 
 * CONSTRAINTS:
 * - 1 <= rows, columns <= 10
 * - 0 <= grid[i][j] <= 3
 * 
 * COMPLEXITY REQUIREMENTS:
 * - Time Complexity: O(r * c), where r is the number of rows and c is the number of columns.
 *   Every seat in the grid is visited exactly once during row-sum calculation.
 * - Auxiliary Space Complexity: O(1). Only a few primitive variables are used to track
 *   the best row index, maximum total, and current row sum.
 */
public class BusiestBusRow {

    /**
     * Encapsulates the result of finding the busiest row.
     */
    public static class RowResult {
        public final int rowIndex;
        public final int total;

        public RowResult(int rowIndex, int total) {
            this.rowIndex = rowIndex;
            this.total = total;
        }

        @Override
        public String toString() {
            return "Row " + rowIndex + ", Total " + total;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof RowResult other)) return false;
            return this.rowIndex == other.rowIndex && this.total == other.total;
        }
    }

    /**
     * Finds the index of the row with the largest total students and that total.
     * If two rows tie, returns the one with the smaller index.
     * 
     * @param grid 2D array where grid[i][j] is the number of students in row i, seat j
     * @return int array where index 0 is the row index and index 1 is the total students: [rowIndex, total]
     */
    public static int[] busiestRow(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return new int[]{-1, 0};
        }

        int bestRowIndex = 0;
        int maxTotal = -1; // -1 ensures that row 0 updates even if its sum is 0

        // Outer loop: iterate through each row
        for (int r = 0; r < grid.length; r++) {
            int currentRowSum = 0;

            // Inner loop: sum up all seats in the current row
            if (grid[r] != null) {
                for (int c = 0; c < grid[r].length; c++) {
                    currentRowSum += grid[r][c];
                }
            }

            // Update best row ONLY when strictly larger to break ties in favor of smaller index
            if (currentRowSum > maxTotal) {
                maxTotal = currentRowSum;
                bestRowIndex = r;
            }
        }

        return new int[]{bestRowIndex, maxTotal};
    }

    /**
     * Convenience method returning structured RowResult.
     * 
     * @param grid 2D array of seat counts
     * @return RowResult object holding row index and total
     */
    public static RowResult findBusiestRow(int[][] grid) {
        int[] result = busiestRow(grid);
        return new RowResult(result[0], result[1]);
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 10: Busiest Bus Row ===");

        // Example from problem description:
        int[][] grid1 = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };
        int[] res1 = busiestRow(grid1);
        System.out.println("Sample 1 Grid:");
        for (int[] row : grid1) {
            System.out.println("  " + Arrays.toString(row));
        }
        System.out.println("Output Array : " + Arrays.toString(res1));
        System.out.println("Formatted    : " + findBusiestRow(grid1));
        System.out.println("Expected     : Row 1, Total 7\n");

        // Tie test case: Row 0 and Row 1 both have total 6. Row 0 must be selected (smaller index).
        int[][] grid2 = {
            {3, 3},
            {2, 4},
            {1, 1}
        };
        System.out.println("Sample 2 (Tie Case - Row 0 vs Row 1 both total 6):");
        System.out.println("Formatted    : " + findBusiestRow(grid2));
        System.out.println("Expected     : Row 0, Total 6\n");

        // All zero grid
        int[][] grid3 = {
            {0, 0, 0},
            {0, 0, 0}
        };
        System.out.println("Sample 3 (All zero grid):");
        System.out.println("Formatted    : " + findBusiestRow(grid3));
        System.out.println("Expected     : Row 0, Total 0");
    }
}
