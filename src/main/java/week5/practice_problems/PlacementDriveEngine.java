package week5.practice_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class PlacementDriveEngine {

    /**
     * CGPA-only quick eligibility check.
     * High academic performers qualify directly regardless of coding score.
     *
     * @param cgpa candidate's CGPA (0.0 - 10.0)
     * @return true if CGPA meets the direct threshold (>= 7.5)
     */
    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    /**
     * Combined CGPA and coding score eligibility check for borderline cases.
     * A borderline CGPA (>= 6.5) can qualify if accompanied by a strong coding test score (>= 60).
     *
     * @param cgpa candidate's CGPA (0.0 - 10.0)
     * @param codingScore candidate's test score (0 - 100)
     * @return true if candidate qualifies under either standard
     */
    public static boolean isEligible(double cgpa, int codingScore) {
        return isEligible(cgpa) || (cgpa >= 6.5 && codingScore >= 60);
    }

    /**
     * Shortlists eligible candidates and ranks them by composite score descending.
     * Uses Arrays.sort relying on Candidate's compareTo implementation.
     *
     * @param candidates array of applicants
     * @return formatted ranking string
     */
    public static String shortlistAndRank(Candidate[] candidates) {
        if (candidates == null || candidates.length == 0) {
            return "";
        }

        List<Candidate> eligibleList = new ArrayList<>();
        for (Candidate c : candidates) {
            if (c != null && (isEligible(c.getCgpa()) || isEligible(c.getCgpa(), c.getCodingScore()))) {
                eligibleList.add(c);
            }
        }

        if (eligibleList.isEmpty()) {
            return "";
        }

        Candidate[] shortlisted = eligibleList.toArray(new Candidate[0]);
        // Sort using Candidate's Comparable implementation (descending by composite score)
        Arrays.sort(shortlisted);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            if (i > 0) {
                sb.append(" | ");
            }
            sb.append(i + 1)
              .append(". ")
              .append(shortlisted[i].getName())
              .append(" (")
              .append(String.format(Locale.US, "%.1f", shortlisted[i].getCompositeScore()))
              .append(")");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
        // Output: 1. Aisha (102.0) | 2. Rohit (100.5) | 3. Karan (85.0)
    }
}
