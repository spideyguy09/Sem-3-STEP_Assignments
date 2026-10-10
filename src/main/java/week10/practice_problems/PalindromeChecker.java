package week10.practice_problems;

import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = scanner.next();
        
        StringBuilder sb = new StringBuilder(word);
        String reversed = sb.reverse().toString();
        
        if (word.equalsIgnoreCase(reversed)) {
            System.out.println(word + " - palindrome");
        } else {
            System.out.println(reversed + " - not a palindrome");
        }
    }
}
