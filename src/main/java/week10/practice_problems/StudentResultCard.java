package week10.practice_problems;

import java.util.Scanner;

class Student {
    String name;
    int[] marks;
    
    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }
    
    public double calculateAverage() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }
    
    public char assignGrade(double average) {
        if (average >= 75) {
            return 'B';
        } else if (average >= 60) {
            return 'C';
        } else if (average >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }
}

public class StudentResultCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = scanner.next();
        
        int[] marks = new int[3];
        System.out.print("Enter 3 marks: ");
        for (int i = 0; i < 3; i++) {
            marks[i] = scanner.nextInt();
        }
        
        Student student = new Student(name, marks);
        double average = student.calculateAverage();
        char grade = student.assignGrade(average);
        
        System.out.printf("%s: Average %.1f, Grade %c\n", name.toUpperCase(), average, grade);
    }
}
