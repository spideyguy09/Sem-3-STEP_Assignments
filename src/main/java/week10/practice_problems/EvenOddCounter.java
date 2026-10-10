package week10.practice_problems;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class EvenOddCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numbers separated by space (enter non-integer to quit): ");
        List<Integer> numbers = new ArrayList<>();
        
        while (scanner.hasNextInt()) {
            numbers.add(scanner.nextInt());
        }
        
        int even = 0;
        int odd = 0;
        for (int num : numbers) {
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}
