package week7.practice_problems;

public class PiggyBank {
    private final String id;
    private int savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            this.savings += amount;
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= this.savings) {
            this.savings -= amount;
        }
    }

    public int getSavings() {
        return this.savings;
    }

    public String getId() {
        return this.id;
    }
}
