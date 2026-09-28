package week5.practice_problems;

public class DuplicateTeamNameFinder {

    /**
     * Scans registered team names using plain nested loops and reports the first duplicate.
     * No Collections class is used.
     *
     * @param teamNames array of registered team names
     * @return "Duplicate Found: <name>" or "No Duplicates Found"
     */
    public static String findDuplicateTeam(String[] teamNames) {
        if (teamNames == null) {
            return "No Duplicates Found";
        }

        // Compare each name only with the names that appear after it
        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i] != null && teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        String[] teams1 = {"ByteForce", "CodeCrafters", "ByteForce"};
        System.out.println(findDuplicateTeam(teams1)); // Output: Duplicate Found: ByteForce

        String[] teams2 = {"ByteForce", "CodeCrafters", "NullPointers"};
        System.out.println(findDuplicateTeam(teams2)); // Output: No Duplicates Found
    }
}
