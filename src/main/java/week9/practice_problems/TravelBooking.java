package week9.practice_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Booking {
    protected double distanceKm;
    protected static final double BOOKING_FEE = 50.0;

    public Booking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    protected abstract double calculateBaseFare();

    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
    
    public abstract String getMode();
}

class BusBooking extends Booking {
    public BusBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    protected double calculateBaseFare() {
        return distanceKm * 2.0;
    }

    @Override
    public String getMode() {
        return "BUS";
    }
}

class TrainBooking extends Booking {
    public TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    protected double calculateBaseFare() {
        return distanceKm * 1.5;
    }

    @Override
    public String getMode() {
        return "TRAIN";
    }
}

class FlightBooking extends Booking {
    public FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    protected double calculateBaseFare() {
        return 2500.0 + (distanceKm * 4.0);
    }

    @Override
    public String getMode() {
        return "FLIGHT";
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<Booking> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double distance = scanner.nextDouble();
            
            if (mode.equals("BUS")) {
                bookings.add(new BusBooking(distance));
            } else if (mode.equals("TRAIN")) {
                bookings.add(new TrainBooking(distance));
            } else if (mode.equals("FLIGHT")) {
                bookings.add(new FlightBooking(distance));
            }
        }
        
        for (Booking b : bookings) {
            System.out.printf("%s: %.2f\n", b.getMode(), b.calculateTotalFare());
        }
    }
}
