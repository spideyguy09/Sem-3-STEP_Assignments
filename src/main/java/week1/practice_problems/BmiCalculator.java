package week1.practice_problems;

import java.util.Random;

public class BmiCalculator {

    public String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");
        System.out.println("--------------------------------------------------");
        
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            
            System.out.printf("Person %d — Height: %.2f m, Weight: %.2f kg | BMI: %.2f | Status: %s%n",
                    (i + 1), heights[i], weights[i], bmi, status);
        }
    }

    public static void main(String[] args) {
        BmiCalculator calculator = new BmiCalculator();
        int teamSize = 10;
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];
        
        Random random = new Random();
        for (int i = 0; i < teamSize; i++) {
            heights[i] = 1.5 + (random.nextDouble() * 0.5); // 1.5 to 2.0 meters
            weights[i] = 50 + (random.nextDouble() * 50); // 50 to 100 kg
        }
        
        calculator.printWellnessReport(heights, weights);
    }
}
