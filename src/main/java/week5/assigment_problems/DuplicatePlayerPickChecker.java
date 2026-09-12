package week5.assigment_problems;

public class DuplicatePlayerPickChecker {

    /**
     * Checks a submitted lineup for repeated player names using plain nested loops.
     * No Collections class is used.
     *
     * @param playerNames array of player names in lineup
     * @return "Duplicate Found: <name>" or "No Duplicates Found"
     */
    public static String findDuplicatePick(String[] playerNames) {
        if (playerNames == null) {
            return "No Duplicates Found";
        }

        // Compare each player only against players that appear after them
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i] != null && playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        String[] lineup1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        System.out.println(findDuplicatePick(lineup1)); // Output: Duplicate Found: Kohli

        String[] lineup2 = {"Kohli", "Bumrah", "Rohit"};
        System.out.println(findDuplicatePick(lineup2)); // Output: No Duplicates Found
    }
}
