package week6.practice_problems;

/**
 * M2. Hostel Mess Wallet Management
 *
 * Encapsulates hostel mess card balance to ensure it never goes negative
 * and prevents direct external modification.
 */
public class MessWallet {
    private double balance;

    /**
     * Initializes wallet with opening balance. Rejects negative opening balance.
     *
     * @param openingBalance initial funds
     */
    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: Opening balance cannot be negative. Initializing balance to 0.0.");
            this.balance = 0.0;
        } else {
            this.balance = openingBalance;
        }
    }

    /**
     * Tops up wallet balance. Rejects amount <= 0.
     *
     * @param amount amount to add
     */
    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: amount must be greater than 0");
            return;
        }
        this.balance += amount;
    }

    /**
     * Deducts amount from wallet balance. Rejects amount greater than current balance.
     *
     * @param amount amount to deduct
     */
    public void deduct(double amount) {
        if (amount <= 0) {
            System.out.println("Deduct rejected: amount must be greater than 0");
            return;
        }
        if (amount > this.balance) {
            System.out.println("Deduct rejected: insufficient balance");
            return;
        }
        this.balance -= amount;
    }

    /**
     * Read-only getter for balance.
     *
     * @return current balance
     */
    public double getBalance() {
        return this.balance;
    }

    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        System.out.println("Balance after top-up: " + wallet.getBalance());

        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}
