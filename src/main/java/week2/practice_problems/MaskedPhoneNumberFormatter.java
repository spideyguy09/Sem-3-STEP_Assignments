package week2.practice_problems;

public class MaskedPhoneNumberFormatter {
    public String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }
        
        StringBuilder masked = new StringBuilder();
        masked.append("XXXXXX");
        masked.append(phone.substring(6));
        masked.insert(6, "-");
        return masked.toString();
    }

    public static void main(String[] args) {
        MaskedPhoneNumberFormatter formatter = new MaskedPhoneNumberFormatter();
        System.out.println(formatter.maskPhoneNumber("9876543210"));
        System.out.println(formatter.maskPhoneNumber("98765"));
    }
}
