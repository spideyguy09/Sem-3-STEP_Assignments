package week8.practice_problems;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract double getAdjustedAmount();
    public abstract String getType();
}

class CardPayment extends Payment {
    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public double getAdjustedAmount() {
        return amount * 1.02;
    }
    
    @Override
    public String getType() {
        return "CARD";
    }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public double getAdjustedAmount() {
        return amount * 1.01;
    }
    
    @Override
    public String getType() {
        return "WALLET";
    }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    public double getAdjustedAmount() {
        return amount;
    }
    
    @Override
    public String getType() {
        return "BANKTRANSFER";
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<Payment> payments = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            if (type.equals("CARD")) {
                payments.add(new CardPayment(amount));
            } else if (type.equals("WALLET")) {
                payments.add(new WalletPayment(amount));
            } else if (type.equals("BANKTRANSFER")) {
                payments.add(new BankTransferPayment(amount));
            }
        }
        
        double total = 0;
        for (Payment p : payments) {
            double adjusted = p.getAdjustedAmount();
            System.out.printf("%s: %.2f\n", p.getType(), adjusted);
            total += adjusted;
        }
        System.out.printf("Total: %.2f\n", total);
    }
}
