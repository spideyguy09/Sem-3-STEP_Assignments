# Week 10 — Assignment Problems & Analysis

This document contains detailed problem descriptions, algorithmic strategies, hints, and complexity analyses for the Week 10 Assignment Problems.

---

## Table of Contents
1. [Problem 10: Busiest Bus Row](#problem-10-busiest-bus-row)
2. [Problem 6: Class Attendance Tracker](#problem-6-class-attendance-tracker)
3. [Problem 8: Duty Roster Rotation](#problem-8-duty-roster-rotation)
4. [Problem 4: Exam Score Band Counter](#problem-4-exam-score-band-counter)
5. [Problem 7: Second-Best Score](#problem-7-second-best-score)
6. [Summary of Complexities](#summary-of-complexities)

---

## Problem 10: Busiest Bus Row

### Task
A college bus records how many students sit in each seat as a 2D grid, where each row is one row of seats. The transport office wants to know which row carries the most students.
Implement a function `busiestRow(grid)` that returns the index of the row with the largest total and that total. If two rows tie, return the one with the smaller index.

### Constraints
- $1 \le \text{rows, columns} \le 10$
- $0 \le \text{grid}[i][j] \le 3$

### Example
```text
grid = [[2, 0, 1],
        [3, 3, 1],
        [1, 1, 1]]

Row 0 sum: 2 + 0 + 1 = 3
Row 1 sum: 3 + 3 + 1 = 7
Row 2 sum: 1 + 1 + 1 = 3

Expected Output: Row 1, Total 7
```

### Algorithmic Approach & Hint
- Maintain two variables: `bestRowIndex = 0` and `maxTotal = -1`.
- Use an outer loop to iterate through each row index $r$ from $0$ to $\text{rows} - 1$.
- Use an inner loop to sum all column values in `grid[r]`.
- Update `bestRowIndex` and `maxTotal` **only when** `currentRowSum > maxTotal` (strictly greater).
- By requiring strict inequality (`>`), when two rows have equal sums, the earlier row index is retained without being overwritten, automatically breaking ties in favor of the smaller index.

### Complexity Analysis
- **Time Complexity:** $\mathcal{O}(r \times c)$, where $r$ is the number of rows and $c$ is the number of columns. Every element in the 2D grid is visited and added exactly once.
- **Auxiliary Space Complexity:** $\mathcal{O}(1)$. Only a constant number of primitive variables (`bestRowIndex`, `maxTotal`, `currentRowSum`) are allocated.

---

## Problem 6: Class Attendance Tracker

### Task
A teacher records attendance for one student as an array of 1s (present) and 0s (absent), one value per day. The teacher wants to know how many days the student was present and the longest run of days the student attended without a break.
Implement a function `attendanceSummary(days)` that returns the number of present days and the length of the longest unbroken run of present days.

### Constraints
- $1 \le \text{length of } days \le 100$
- Each value is $0$ or $1$

### Examples
- **Sample 1:**
  - `days = [1, 1, 0, 1, 1, 1, 0, 1]`
  - Output: `Present: 6, Longest streak: 3`
- **Sample 2:**
  - `days = [0, 0, 0]`
  - Output: `Present: 0, Longest streak: 0`

### Single-Pass Analysis
**Can both answers be found in a single pass?**
- **Yes.** Both answers are computed simultaneously during a single forward iteration of the array:
  - Maintain `presentDays = 0`, `currentStreak = 0`, and `longestStreak = 0`.
  - For each day:
    - If `day == 1`:
      - Increment `presentDays++`.
      - Increment `currentStreak++`.
      - Update `longestStreak = Math.max(longestStreak, currentStreak)`.
    - If `day == 0`:
      - Reset `currentStreak = 0`.
- At the end of the pass, `presentDays` contains the total count of 1s and `longestStreak` holds the maximum unbroken sequence of consecutive 1s.

### Complexity Analysis
- **Time Complexity:** $\mathcal{O}(n)$, where $n$ is the length of `days`. Exactly one pass over $n$ elements.
- **Auxiliary Space Complexity:** $\mathcal{O}(1)$. Only primitive scalar counters are used.

---

## Problem 8: Duty Roster Rotation

### Task
A hostel rotates its cleaning duty roster every week by moving each name $k$ places to the right; names that go past the end wrap around to the front.
Implement a function `rotateRoster(names, k)` that returns the roster after rotating it to the right by $k$ places. $k$ may be larger than the number of names.

### Constraints
- $1 \le \text{length of } names \le 100$
- $0 \le k \le 10^9$

### Examples
- **Sample 1:**
  - `names = [A, B, C, D, E], k = 2`
  - Output: `[D, E, A, B, C]`
- **Sample 2:**
  - `names = [A, B, C, D, E], k = 7`
  - Output: `[D, E, A, B, C]` ($7 \pmod 5 = 2$)

### Why Rotating One Place at a Time, $k$ Times, is Slow
- A single shift of an array with $n$ elements requires moving every element one position to the right, which takes $\mathcal{O}(n)$ time.
- Repeating this step $k$ times takes $\mathcal{O}(n \times k)$ time.
- Given the constraints:
  - $n = 100$
  - $k = 10^9$
  - Naive total operations: $100 \times 10^9 = 10^{11}$ operations.
  - On a typical modern CPU executing roughly $10^8$ operations per second, $10^{11}$ operations will take **over 15 to 20 minutes**, causing a Time Limit Exceeded (TLE) error.
- **Optimized Solution:**
  - Rotating an array of size $n$ by $n$ places results in the exact same original array (a full cycle).
  - Therefore, rotating by $k$ places is identical to rotating by $k \pmod n$ places.
  - Since $k \pmod n < n \le 100$, computing the new index as `(i + (k % n)) % n` maps every element to its destination in a single $\mathcal{O}(n)$ pass (at most 100 operations), executing in under 1 millisecond.

### Complexity Analysis
- **Time Complexity:** $\mathcal{O}(n)$, where $n$ is the length of `names`. Modulo reduction takes $\mathcal{O}(1)$ and the placement takes $\mathcal{O}(n)$.
- **Space Complexity:**
  - Returning a new array: $\mathcal{O}(n)$ auxiliary space.
  - In-place reversal approach: $\mathcal{O}(1)$ auxiliary space.

---

## Problem 4: Exam Score Band Counter

### Task
A university stores the marks of all students in an exam as an array sorted in ascending order; marks can repeat. Faculty members frequently ask how many students scored within a band `[low, high]`, inclusive of both ends.
Implement a function `countInBand(scores, low, high)` that returns the number of scores $s$ such that $\text{low} \le s \le \text{high}$. The array is large and queried very often, so your solution must not scan the scores one by one.

### Constraints
- $1 \le \text{length of } scores \le 10^6$
- `scores` is sorted in ascending order
- $0 \le \text{low} \le \text{high} \le 100$

### Examples
- **Sample 1:**
  - `scores = [35, 42, 42, 50, 58, 58, 58, 63, 71, 88], low = 42, high = 58`
  - Output: `6` (Scores: 42, 42, 50, 58, 58, 58)
- **Sample 2:**
  - `scores = [35, 42, 42, 50, 58, 58, 58, 63, 71, 88], low = 90, high = 100`
  - Output: `0`

### Duplicates at Band Boundaries
- A standard binary search terminates as soon as any matching value is found. However, because marks can repeat:
  1. **At the `low` edge:** Multiple students may share the score `low` (e.g., `[42, 42]`). A standard binary search might find the rightmost `42` and miss the leftmost one. To include **all** students scoring $\ge \text{low}$, we must find the **first index** where $\text{scores}[i] \ge \text{low}$ (the **Lower Bound**).
  2. **At the `high` edge:** Multiple students may share the score `high` (e.g., `[58, 58, 58]`). A standard binary search could land on the first `58` and cut off the remaining ones. To include **all** students scoring $\le \text{high}$, we must find the **first index** strictly greater than `high` ($\text{scores}[i] > \text{high}$, the **Upper Bound**).
- The total count in the band $[\text{low}, \text{high}]$ is:
  $$\text{count} = \text{upperBound}(\text{scores}, \text{high}) - \text{lowerBound}(\text{scores}, \text{low})$$

### Complexity Comparison
| Approach | Time Complexity (Per Query) | Additional Space | Performance with $n = 10^6, Q = 10^4$ |
| :--- | :--- | :--- | :--- |
| **Linear Scan** | $\mathcal{O}(n)$ | $\mathcal{O}(1)$ | $10^4 \times 10^6 = 10^{10}$ ops (Seconds/Timeout) |
| **Dual Binary Search** | $\mathcal{O}(\log n)$ | $\mathcal{O}(1)$ | $10^4 \times 20 = 2 \times 10^5$ ops (< 5 milliseconds) |

---

## Problem 7: Second-Best Score

### Task
A quiz app stores the scores of all players in an array. Prizes go to the top two different scores, so the app needs the second-highest distinct score. If every player has the same score, there is no second-highest score.
Implement a function `secondHighest(scores)` that returns the second-highest distinct score, or -1 if it does not exist.

### Constraints
- $1 \le \text{length of } scores \le 1000$
- $0 \le \text{scores}[i] \le 100$
- **Do not sort the array**

### Examples
- **Sample 1:**
  - `scores = [45, 78, 92, 78, 60]`
  - Output: `78`
- **Sample 2:**
  - `scores = [50, 50, 50]`
  - Output: `-1`

### Comparison: Single-Pass Scan vs. Sorting First
1. **Sorting the Array First:**
   - **Time Complexity:** $\mathcal{O}(n \log n)$ to sort the array, followed by an $\mathcal{O}(n)$ backward scan to identify the first distinct score strictly less than the maximum.
   - **Space Complexity:** $\mathcal{O}(n)$ (or $\mathcal{O}(\log n)$ stack space) depending on whether the array is cloned or sorted in-place.
   - **Violation:** Directly violates the constraint: *"Do not sort the array"*.
2. **Single-Pass Linear Scan (Implemented Solution):**
   - **Time Complexity:** $\mathcal{O}(n)$. We traverse the array exactly once from start to finish.
   - **Space Complexity:** $\mathcal{O}(1)$. We only track two variables: `highest = -1` and `second = -1`.
   - **Logic:**
     - If `score > highest`: previous `highest` becomes `second`, and `highest = score`.
     - Else if `score < highest && score > second`: `second = score`.
     - Scores equal to `highest` or $\le \text{second}$ are ignored.
   - **Result:** After one pass, `second` is the second-highest distinct score, or `-1` if all values were identical.

---

## Summary of Complexities

| Problem | Class Name | Time Complexity | Space Complexity | Key Technique |
| :--- | :--- | :--- | :--- | :--- |
| **Problem 10: Busiest Bus Row** | `BusiestBusRow` | $\mathcal{O}(r \times c)$ | $\mathcal{O}(1)$ | 2D Grid Row Summation, Strict Inequality for Tie-Breaking |
| **Problem 6: Class Attendance Tracker** | `ClassAttendanceTracker` | $\mathcal{O}(n)$ | $\mathcal{O}(1)$ | Single-Pass Running Counter with Streak Reset |
| **Problem 8: Duty Roster Rotation** | `DutyRosterRotation` | $\mathcal{O}(n)$ | $\mathcal{O}(n)$ / $\mathcal{O}(1)$ | Modulo Arithmetic ($k \pmod n$) eliminating $10^{11}$ loop steps |
| **Problem 4: Exam Score Band Counter** | `ExamScoreBandCounter` | $\mathcal{O}(\log n)$ | $\mathcal{O}(1)$ | Dual Binary Search (Lower Bound + Strict Upper Bound) |
| **Problem 7: Second-Best Score** | `SecondBestScore` | $\mathcal{O}(n)$ | $\mathcal{O}(1)$ | Single-Pass Two-Variable Tracking without Sorting |
