package week7.practice_problems;

public class Scorecard {
    private boolean[] results;
    private int currentIndex;

    public Scorecard(int totalQuestions) {
        this.results = new boolean[totalQuestions];
        this.currentIndex = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (this.currentIndex < this.results.length) {
            this.results[this.currentIndex] = isCorrect;
            this.currentIndex++;
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < this.currentIndex; i++) {
            if (this.results[i]) {
                score++;
            }
        }
        return score;
    }
}
