package week1.assigment_problems;

import java.util.Scanner;

public class TypingAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        int length = Math.min(original.length(), typed.length());
        int total = original.length();
        int matched = 0;
        int firstMismatchPos = -1;
        char origChar = ' ', typedChar = ' ';

        for (int i = 0; i < length; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1;
                origChar = original.charAt(i);
                typedChar = typed.charAt(i);
            }
        }

        double accuracy = total == 0 ? 100.0 : ((double) matched / total) * 100.0;
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | ", matched, total, accuracy);

        if (firstMismatchPos == -1) {
            System.out.println("No Mismatches");
        } else {
            System.out.printf("First Mismatch at position %d ('%c' vs '%c')\n", firstMismatchPos, origChar, typedChar);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String original = scanner.nextLine();
        String typed = scanner.nextLine();
        checkTypingAccuracy(original, typed);
        scanner.close();
    }
}
