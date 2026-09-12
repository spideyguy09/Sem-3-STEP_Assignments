package week5.assigment_problems;

/**
 * Encapsulated Player class for the fantasy league auto-draft.
 * Implements Comparable to rank players by fantasy performance (batting average) descending.
 */
public class Player implements Comparable<Player> {
    private final String name;
    private final int matchesPlayed;
    private final double battingAverage;
    private final boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public String getName() {
        return name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    public boolean isInjured() {
        return injured;
    }

    /**
     * Compares players in descending order of batting average.
     */
    @Override
    public int compareTo(Player other) {
        return Double.compare(other.getBattingAverage(), this.getBattingAverage());
    }

    @Override
    public String toString() {
        return name;
    }
}
