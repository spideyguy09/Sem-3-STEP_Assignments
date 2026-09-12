package week5.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FantasyLeagueAutoDraftEngine {

    /**
     * Experience-only eligibility rule for established players.
     * Players with 10 or more matches qualify directly regardless of fitness.
     *
     * @param matchesPlayed total matches played
     * @return true if player meets the veteran threshold
     */
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    /**
     * Combined matches and fitness rule for players who do not meet the veteran cutoff.
     * A player with at least 5 matches qualifies if they are currently fit (!injured).
     *
     * @param matchesPlayed total matches played
     * @param injured current injury status
     * @return true if player qualifies under either experience or combined rule
     */
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return isDraftable(matchesPlayed) || (matchesPlayed >= 5 && !injured);
    }

    /**
     * Shortlists draftable players and ranks them by fantasy performance (descending).
     * Uses Arrays.sort relying on Player's compareTo implementation.
     *
     * @param players array of candidate players
     * @return formatted draft ranking string
     */
    public static String draftAndRank(Player[] players) {
        if (players == null || players.length == 0) {
            return "";
        }

        List<Player> draftableList = new ArrayList<>();
        for (Player p : players) {
            if (p != null && (isDraftable(p.getMatchesPlayed()) || isDraftable(p.getMatchesPlayed(), p.isInjured()))) {
                draftableList.add(p);
            }
        }

        if (draftableList.isEmpty()) {
            return "";
        }

        Player[] draftable = draftableList.toArray(new Player[0]);
        // Sort using Player's Comparable implementation (descending order)
        Arrays.sort(draftable);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append(i + 1)
                  .append(". ")
                  .append(draftable[i].getName());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
        // Output: 1. Rahul | 2. Virat | 3. Dev
    }
}
