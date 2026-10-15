package week1.assigment_problems;

import java.util.Scanner;

public class WarehouseInventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int totalB = 0;

        for (int qty : sectionA) {
            totalA += qty;
        }
        for (int qty : sectionB) {
            totalB += qty;
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        int maxQty = Integer.MIN_VALUE;
        String maxSection = "Section A";
        int maxItemIndex = 1;

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > maxQty) {
                maxQty = sectionA[i];
                maxSection = "Section A";
                maxItemIndex = i + 1;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > maxQty) {
                maxQty = sectionB[i];
                maxSection = "Section B";
                maxItemIndex = i + 1;
            }
        }

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)\n",
                totalA, totalB, status, maxQty, maxSection, maxItemIndex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] sectionA = new int[n];
        for (int i = 0; i < n; i++) {
            sectionA[i] = scanner.nextInt();
        }
        int[] sectionB = new int[n];
        for (int i = 0; i < n; i++) {
            sectionB[i] = scanner.nextInt();
        }
        analyzeInventory(sectionA, sectionB);
        scanner.close();
    }
}
