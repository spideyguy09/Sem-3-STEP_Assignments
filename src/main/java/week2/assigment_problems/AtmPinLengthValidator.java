package week2.assigment_problems;

public class AtmPinLengthValidator {
    public void checkPinLength(String pin) {
        if (pin.length() == 4) {
            System.out.println("PIN length OK.");
        } else {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        }
    }

    public static void main(String[] args) {
        AtmPinLengthValidator validator = new AtmPinLengthValidator();
        validator.checkPinLength("482");
        validator.checkPinLength("4820");
    }
}
