package week9.assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface NightService {
    double applyNightSurcharge(double baseFare);
}

abstract class Cab {
    protected double km;
    protected String time;
    protected static final double MIN_FARE = 100.0;

    public Cab(double km, String time) {
        this.km = km;
        this.time = time;
    }

    protected abstract double getRatePerKm();
    public abstract String getType();

    public double calculateBaseFare() {
        double fare = km * getRatePerKm();
        return Math.max(fare, MIN_FARE);
    }
    
    public String getTime() {
        return time;
    }
}

class MiniCab extends Cab {
    public MiniCab(double km, String time) {
        super(km, time);
    }

    @Override
    protected double getRatePerKm() {
        return 10.0;
    }

    @Override
    public String getType() {
        return "MINI";
    }
}

class SedanCab extends Cab implements NightService {
    public SedanCab(double km, String time) {
        super(km, time);
    }

    @Override
    protected double getRatePerKm() {
        return 14.0;
    }

    @Override
    public double applyNightSurcharge(double baseFare) {
        return baseFare * 1.20;
    }

    @Override
    public String getType() {
        return "SEDAN";
    }
}

class SUVCab extends Cab implements NightService {
    public SUVCab(double km, String time) {
        super(km, time);
    }

    @Override
    protected double getRatePerKm() {
        return 18.0;
    }

    @Override
    public double applyNightSurcharge(double baseFare) {
        return baseFare * 1.20;
    }

    @Override
    public String getType() {
        return "SUV";
    }
}

public class CityCabFare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = Integer.parseInt(scanner.nextLine().trim());
        
        List<Cab> cabs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split(" ");
            String type = parts[0];
            double km = Double.parseDouble(parts[1]);
            String time = parts[2];
            
            if (type.equals("MINI")) {
                cabs.add(new MiniCab(km, time));
            } else if (type.equals("SEDAN")) {
                cabs.add(new SedanCab(km, time));
            } else if (type.equals("SUV")) {
                cabs.add(new SUVCab(km, time));
            }
        }
        
        double total = 0;
        for (Cab c : cabs) {
            if (c.getTime().equals("NIGHT") && !(c instanceof NightService)) {
                System.out.printf("%s: night service not available\n", c.getType());
            } else {
                double fare = c.calculateBaseFare();
                if (c.getTime().equals("NIGHT") && c instanceof NightService) {
                    fare = ((NightService) c).applyNightSurcharge(fare);
                }
                System.out.printf("%s: %.2f\n", c.getType(), fare);
                total += fare;
            }
        }
        System.out.printf("Total: %.2f\n", total);
    }
}
