package week9.assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface SaverMode {
    double applySaverReduction(double units);
}

abstract class Appliance {
    protected double hours;
    protected boolean isSaverRequested;

    public Appliance(double hours, boolean isSaverRequested) {
        this.hours = hours;
        this.isSaverRequested = isSaverRequested;
    }

    protected abstract double getPowerRating();
    public abstract String getType();

    public double calculateBaseUnits() {
        return (getPowerRating() * hours) / 1000.0;
    }
    
    public boolean isSaverRequested() {
        return isSaverRequested;
    }
}

class Fridge extends Appliance {
    public Fridge(double hours, boolean isSaverRequested) {
        super(hours, isSaverRequested);
    }

    @Override
    protected double getPowerRating() {
        return 150.0;
    }

    @Override
    public String getType() {
        return "FRIDGE";
    }
}

class AirConditioner extends Appliance implements SaverMode {
    public AirConditioner(double hours, boolean isSaverRequested) {
        super(hours, isSaverRequested);
    }

    @Override
    protected double getPowerRating() {
        return 1500.0;
    }

    @Override
    public double applySaverReduction(double units) {
        return units * 0.75;
    }

    @Override
    public String getType() {
        return "AC";
    }
}

class TV extends Appliance {
    public TV(double hours, boolean isSaverRequested) {
        super(hours, isSaverRequested);
    }

    @Override
    protected double getPowerRating() {
        return 100.0;
    }

    @Override
    public String getType() {
        return "TV";
    }
}

class Washer extends Appliance implements SaverMode {
    public Washer(double hours, boolean isSaverRequested) {
        super(hours, isSaverRequested);
    }

    @Override
    protected double getPowerRating() {
        return 500.0;
    }

    @Override
    public double applySaverReduction(double units) {
        return units * 0.75;
    }

    @Override
    public String getType() {
        return "WASHER";
    }
}

public class ApplianceEnergy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = Integer.parseInt(scanner.nextLine().trim());
        
        List<Appliance> appliances = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split(" ");
            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean saver = parts.length > 2 && parts[2].equals("SAVER");
            
            if (type.equals("FRIDGE")) {
                appliances.add(new Fridge(hours, saver));
            } else if (type.equals("AC")) {
                appliances.add(new AirConditioner(hours, saver));
            } else if (type.equals("TV")) {
                appliances.add(new TV(hours, saver));
            } else if (type.equals("WASHER")) {
                appliances.add(new Washer(hours, saver));
            }
        }
        
        double totalCost = 0;
        for (Appliance a : appliances) {
            if (a.isSaverRequested() && !(a instanceof SaverMode)) {
                System.out.printf("%s: saver mode not supported\n", a.getType());
            } else {
                double units = a.calculateBaseUnits();
                if (a.isSaverRequested() && a instanceof SaverMode) {
                    units = ((SaverMode) a).applySaverReduction(units);
                }
                double cost = units * 8.0;
                System.out.printf("%s: Units=%.2f Cost=%.2f\n", a.getType(), units, cost);
                totalCost += cost;
            }
        }
        System.out.printf("Total Cost: %.2f\n", totalCost);
    }
}
