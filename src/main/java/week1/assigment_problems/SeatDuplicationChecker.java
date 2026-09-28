package week1.assigment_problems;

import java.util.Scanner;

public class SeatDuplicationChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("No Duplicate Seats Found");
            return;
        }

        boolean duplicateFound = false;
        boolean[] reported = new boolean[seatNumbers.length];

        for (int i = 0; i < seatNumbers.length; i++) {
            if (reported[i]) {
                continue;
            }
            boolean isDuplicate = false;
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    isDuplicate = true;
                    reported[j] = true;
                }
            }
            if (isDuplicate) {
                System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                duplicateFound = true;
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] seatNumbers = new int[n];
        for (int i = 0; i < n; i++) {
            seatNumbers[i] = scanner.nextInt();
        }
        checkDuplicateSeats(seatNumbers);
        scanner.close();
    }
}
