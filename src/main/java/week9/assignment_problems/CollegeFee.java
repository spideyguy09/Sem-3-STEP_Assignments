package week9.assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface BusUser {
    double getTransportFee();
}

abstract class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public abstract double calculateTuition();
    public String getName() {
        return name;
    }
}

class DayScholar extends Student implements BusUser {
    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 40000.0;
    }

    @Override
    public double getTransportFee() {
        return 12000.0;
    }
}

class Hosteller extends Student {
    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 40000.0 + 60000.0;
    }
}

class Scholar extends Student implements BusUser {
    public Scholar(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 20000.0;
    }

    @Override
    public double getTransportFee() {
        return 12000.0;
    }
}

public class CollegeFee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            
            if (type.equals("DAY_SCHOLAR")) {
                students.add(new DayScholar(name));
            } else if (type.equals("HOSTELLER")) {
                students.add(new Hosteller(name));
            } else if (type.equals("SCHOLAR")) {
                students.add(new Scholar(name));
            }
        }
        
        double totalCollected = 0;
        for (Student s : students) {
            double fee = s.calculateTuition();
            if (s instanceof BusUser) {
                fee += ((BusUser) s).getTransportFee();
            }
            System.out.printf("%s: %.2f\n", s.getName(), fee);
            totalCollected += fee;
        }
        System.out.printf("Total Collected: %.2f\n", totalCollected);
    }
}
