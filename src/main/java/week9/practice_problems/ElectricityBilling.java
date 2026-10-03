package week9.practice_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Connection {
    protected int units;

    public Connection(int units) {
        this.units = units;
    }

    public abstract double calculateBill();
    public abstract String getType();
}

class Home extends Connection {
    public Home(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        } else {
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }

    @Override
    public String getType() {
        return "HOME";
    }
}

class Shop extends Connection {
    public Shop(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0;
    }

    @Override
    public String getType() {
        return "SHOP";
    }
}

class Factory extends Connection {
    public Factory(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return Math.max(units * 6.0, 1000.0);
    }

    @Override
    public String getType() {
        return "FACTORY";
    }
}

public class ElectricityBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<Connection> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();
            
            if (type.equals("HOME")) {
                connections.add(new Home(units));
            } else if (type.equals("SHOP")) {
                connections.add(new Shop(units));
            } else if (type.equals("FACTORY")) {
                connections.add(new Factory(units));
            }
        }
        
        double total = 0;
        for (Connection c : connections) {
            double bill = c.calculateBill();
            System.out.printf("%s: %.2f\n", c.getType(), bill);
            total += bill;
        }
        System.out.printf("Total: %.2f\n", total);
    }
}
