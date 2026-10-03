package week9.assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Insurable {
    double calculateInsurance();
}

abstract class Parcel {
    protected double weight;
    protected double declaredValue;

    public Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateCharge();
    public abstract String getType();
}

class StandardParcel extends Parcel {
    public StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 40.0 + (10.0 * weight);
    }

    @Override
    public String getType() {
        return "STANDARD";
    }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 80.0 + (15.0 * weight);
    }

    @Override
    public double calculateInsurance() {
        return 0.02 * declaredValue;
    }

    @Override
    public String getType() {
        return "EXPRESS";
    }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 40.0 + (10.0 * weight) + 50.0;
    }

    @Override
    public double calculateInsurance() {
        return 0.02 * declaredValue;
    }

    @Override
    public String getType() {
        return "FRAGILE";
    }
}

public class ParcelShipping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<Parcel> parcels = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double declaredValue = scanner.nextDouble();
            
            if (type.equals("STANDARD")) {
                parcels.add(new StandardParcel(weight, declaredValue));
            } else if (type.equals("EXPRESS")) {
                parcels.add(new ExpressParcel(weight, declaredValue));
            } else if (type.equals("FRAGILE")) {
                parcels.add(new FragileParcel(weight, declaredValue));
            }
        }
        
        double grandTotal = 0;
        for (Parcel p : parcels) {
            double charge = p.calculateCharge();
            double insurance = 0;
            if (p instanceof Insurable) {
                insurance = ((Insurable) p).calculateInsurance();
            }
            double total = charge + insurance;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n", p.getType(), charge, insurance, total);
            grandTotal += total;
        }
        System.out.printf("Grand Total: %.2f\n", grandTotal);
    }
}
