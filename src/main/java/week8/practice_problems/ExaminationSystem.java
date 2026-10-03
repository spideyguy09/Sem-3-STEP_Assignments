package week8.practice_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(String questionText, String correctAnswer, String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double evaluate();
    public abstract String getType();
}

class MCQ extends Question {
    public MCQ(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluate() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0.0;
    }

    @Override
    public String getType() {
        return "MCQ";
    }
}

class TF extends Question {
    public TF(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluate() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0.0;
    }

    @Override
    public String getType() {
        return "TF";
    }
}

class Essay extends Question {
    public Essay(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluate() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        String studentAnsLower = studentAnswer.toLowerCase();
        
        for (String keyword : keywords) {
            if (studentAnsLower.contains(keyword.trim().toLowerCase())) {
                matchCount++;
            }
        }
        
        if (matchCount >= 2) {
            return points * 0.75;
        } else if (matchCount == 1) {
            return points * 0.50;
        } else {
            return 0.0;
        }
    }

    @Override
    public String getType() {
        return "ESSAY";
    }
}

public class ExaminationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = Integer.parseInt(scanner.nextLine().trim());
        
        List<Question> questions = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\"");
            String type = parts[0].trim();
            String qText = parts[1];
            String cAns = parts[3];
            String sAns = parts[5];
            double points = Double.parseDouble(parts[6].trim());
            
            if (type.equals("MCQ")) {
                questions.add(new MCQ(qText, cAns, sAns, points));
            } else if (type.equals("TF")) {
                questions.add(new TF(qText, cAns, sAns, points));
            } else if (type.equals("ESSAY")) {
                questions.add(new Essay(qText, cAns, sAns, points));
            }
        }
        
        double totalScore = 0;
        for (Question q : questions) {
            double score = q.evaluate();
            System.out.printf("%s: %.2f\n", q.getType(), score);
            totalScore += score;
        }
        System.out.printf("Total Score: %.2f\n", totalScore);
    }
}
