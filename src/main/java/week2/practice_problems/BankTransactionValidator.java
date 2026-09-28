package week2.practice_problems;

public class BankTransactionValidator {
    public String normalizeReference(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmed = raw.trim();
        if (trimmed.length() >= 3) {
            String firstThree = trimmed.substring(0, 3).toUpperCase();
            String rest = trimmed.substring(3);
            return firstThree + rest;
        }
        return trimmed.toUpperCase();
    }

    public String validateAndFormat(String reference) {
        if (reference == null || reference.length() != 14) {
            return "Invalid: wrong length";
        }
        
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }
        
        String bankCode = reference.substring(0, 3);
        String dd = reference.substring(3, 5);
        String mm = reference.substring(5, 7);
        String yy = reference.substring(7, 9);
        String seq = reference.substring(9, 14);
        
        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(bankCode).append("] DATE: ")
                 .append(dd).append("/").append(mm).append("/").append(yy)
                 .append(" | SEQ: ").append(seq);
                 
        return formatted.toString();
    }

    public static void main(String[] args) {
        BankTransactionValidator validator = new BankTransactionValidator();
        
        String raw1 = " hdf03022600042 ";
        String normalized1 = validator.normalizeReference(raw1);
        System.out.println(validator.validateAndFormat(normalized1));
        
        String raw2 = "12F03022600042";
        String normalized2 = validator.normalizeReference(raw2);
        System.out.println(validator.validateAndFormat(normalized2));
    }
}
