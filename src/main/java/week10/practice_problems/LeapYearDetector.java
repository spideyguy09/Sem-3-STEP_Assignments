package week10.practice_problems;

import java.util.Scanner;

public class LeapYearDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();
        
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        
        if (isLeap) {
            System.out.println("Leap year");
        } else {
            System.out.println("Not a leap year");
        }
    }
}
