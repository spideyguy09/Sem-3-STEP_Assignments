package week7.assigment_problems;

public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int len = this.password.length();
        if (len < 6) {
            return "Weak";
        } else if (len >= 6 && len <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}
