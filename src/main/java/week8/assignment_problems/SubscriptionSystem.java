package week8.assignment_problems;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Subscription {
    protected String name;
    protected LocalDate startDate;

    public Subscription(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public abstract LocalDate getRenewalDate();
    public String getName() {
        return name;
    }
}

class BasicPlan extends Subscription {
    public BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends Subscription {
    public StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends Subscription {
    public PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class SubscriptionSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<Subscription> subscriptions = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            String dateStr = scanner.next();
            LocalDate startDate = LocalDate.parse(dateStr);
            
            if (type.equals("BASIC")) {
                subscriptions.add(new BasicPlan(name, startDate));
            } else if (type.equals("STANDARD")) {
                subscriptions.add(new StandardPlan(name, startDate));
            } else if (type.equals("PREMIUM")) {
                subscriptions.add(new PremiumPlan(name, startDate));
            }
        }
        
        for (Subscription sub : subscriptions) {
            System.out.println(sub.getName() + ": " + sub.getRenewalDate());
        }
    }
}
