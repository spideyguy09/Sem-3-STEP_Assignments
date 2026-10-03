package week9.assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Ticket {
    protected int count;
    protected static final double CONVENIENCE_FEE = 20.0;

    public Ticket(int count) {
        this.count = count;
    }

    protected abstract double getPrice();

    public double calculateAmount() {
        return (getPrice() * count) + (CONVENIENCE_FEE * count);
    }
    
    public abstract String getSeatType();
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super(count);
    }

    @Override
    protected double getPrice() {
        return 150.0;
    }

    @Override
    public String getSeatType() {
        return "REGULAR";
    }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super(count);
    }

    @Override
    protected double getPrice() {
        return 250.0;
    }

    @Override
    public String getSeatType() {
        return "PREMIUM";
    }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super(count);
    }

    @Override
    protected double getPrice() {
        return 400.0;
    }

    @Override
    public String getSeatType() {
        return "RECLINER";
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int count = scanner.nextInt();
            
            if (type.equals("REGULAR")) {
                tickets.add(new RegularTicket(count));
            } else if (type.equals("PREMIUM")) {
                tickets.add(new PremiumTicket(count));
            } else if (type.equals("RECLINER")) {
                tickets.add(new ReclinerTicket(count));
            }
        }
        
        double total = 0;
        for (Ticket t : tickets) {
            double amount = t.calculateAmount();
            System.out.printf("%s: %.2f\n", t.getSeatType(), amount);
            total += amount;
        }
        System.out.printf("Total: %.2f\n", total);
    }
}
