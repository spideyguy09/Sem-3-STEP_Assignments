package week1.practice_problems;

import java.util.Random;

public class RockPaperScissorsGame {
    
    public String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        
        return "Computer Wins";
    }

    public static void main(String[] args) {
        RockPaperScissorsGame game = new RockPaperScissorsGame();
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"}; // Predefined list
        int wins = 0;
        int losses = 0;
        int draws = 0;
        
        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("-------------------------------------------------");
        
        for (int i = 0; i < playerMoves.length; i++) {
            String pMove = playerMoves[i];
            String cMove = moves[random.nextInt(3)];
            String result = game.playRound(pMove, cMove);
            
            System.out.printf("Round %d — Player: %s, Computer: %s | %s%n", (i + 1), pMove, cMove, result);
            
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }
        
        double winPercentage = (double) wins / playerMoves.length * 100;
        
        System.out.println("\nFinal Summary (after " + playerMoves.length + " rounds)");
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, winPercentage);
    }
}
