package week6.assigment_problems;

/**
 * M2. Payroll Salary Management
 *
 * Encapsulates payroll fields (basicSalary, bonus) and controls modifications
 * via validated methods to ensure net salary cannot be set directly.
 */
public class PayrollAccount {
    private double basicSalary;
    private double bonus;

    /**
     * Constructs a PayrollAccount with an initial basic salary.
     * Rejects negative values, starting at 0.0 instead with a warning.
     *
     * @param basicSalary initial basic salary
     */
    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: Basic salary cannot be negative. Initializing to 0.0.");
            this.basicSalary = 0.0;
        } else {
            this.basicSalary = basicSalary;
        }
        this.bonus = 0.0;
    }

    /**
     * Credits bonus to the account. Rejects amount <= 0.
     *
     * @param amount bonus amount to credit
     */
    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Credit bonus rejected: amount must be greater than 0");
            return;
        }
        this.bonus += amount;
        System.out.println("Bonus credited: Rs " + amount);
    }

    /**
     * Deducts tax by reducing basicSalary by given percentage.
     * Rejects percent outside 0 to 100 range.
     *
     * @param percent tax percentage (0 - 100)
     */
    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Tax deduction rejected: percent must be between 0 and 100");
            return;
        }
        this.basicSalary -= this.basicSalary * (percent / 100.0);
        if (percent == (long) percent) {
            System.out.println("Tax deducted: " + (long) percent + "%");
        } else {
            System.out.println("Tax deducted: " + percent + "%");
        }
    }

    /**
     * Returns net salary (basicSalary + bonus) as read-only.
     *
     * @return net salary
     */
    public double getNetSalary() {
        return this.basicSalary + this.bonus;
    }

    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}
