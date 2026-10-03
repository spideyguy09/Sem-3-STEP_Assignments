package week8.assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Customer {
    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();
    public abstract String getType();
}

class Student extends Customer {
    public Student(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.90;
    }

    @Override
    public String getType() {
        return "STUDENT";
    }
}

class Staff extends Customer {
    public Staff(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.95;
    }

    @Override
    public String getType() {
        return "STAFF";
    }
}

class Guest extends Customer {
    public Guest(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount + 10.0;
    }

    @Override
    public String getType() {
        return "GUEST";
    }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<Customer> customers = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            
            if (type.equals("STUDENT")) {
                customers.add(new Student(amount));
            } else if (type.equals("STAFF")) {
                customers.add(new Staff(amount));
            } else if (type.equals("GUEST")) {
                customers.add(new Guest(amount));
            }
        }
        
        double total = 0;
        for (Customer c : customers) {
            double finalAmount = c.calculateFinalAmount();
            System.out.printf("%s: %.2f\n", c.getType(), finalAmount);
            total += finalAmount;
        }
        System.out.printf("Total: %.2f\n", total);
    }
}
