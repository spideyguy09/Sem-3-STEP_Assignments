package week2.assigment_problems;

public class LibraryIsbnNormalizer {
    public String normalizeCode(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        String firstThree = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return firstThree + rest;
    }

    public String validateAndFormat(String code) {
        if (code == null || code.length() != 13) {
            System.out.println("Invalid: wrong length");
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                System.out.println("Invalid: publisher code must be 3 letters");
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                System.out.println("Invalid: non-digit body");
                return "Invalid: non-digit body";
            }
        }

        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] ");
        sb.append("YEAR: ").append(year).append(" | ");
        sb.append("CATALOG: ").append(catalog);

        String result = sb.toString();
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        LibraryIsbnNormalizer normalizer = new LibraryIsbnNormalizer();
        
        String raw1 = " pen2026004251 ";
        String code1 = normalizer.normalizeCode(raw1);
        normalizer.validateAndFormat(code1);

        String raw2 = "12N2026004251";
        String code2 = normalizer.normalizeCode(raw2);
        normalizer.validateAndFormat(code2);
    }
}
