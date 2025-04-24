import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class GamePopup {
    public String getUserChoice(){
        String userChoice;
        while(true){
            userChoice = JOptionPane.showInputDialog("Choose: rock, paper or scissors");

            if (userChoice==null){
                JOptionPane.showMessageDialog(null,"You cancelled the game!");
                System.exit(0);
            }

            if (userChoice.equals("rock")||userChoice.equals("paper")||userChoice.equals("scissors")){
                return userChoice;
            }
            else {
                JOptionPane.showMessageDialog(null,"Invalid Response!");
            }
        }
    }

    public String getComputerChoice(){
        Random random = new Random();
        int computerChoice = random.nextInt(3);
        String computerMove = "";

        if (computerChoice == 0){
            computerMove = "rock";
        }
        else if (computerChoice == 1){
            computerMove = "paper";
        }
        else {
            computerMove = "scissors";
        }

        return computerMove;
    }

    public String getWinner(String userChoice, String computerMove){
        if (userChoice.equals(computerMove)) {
            return "tie";
        } else if (userChoice.equals("rock") && computerMove.equals("scissors")||
                userChoice.equals("paper") && computerMove.equals("rock")||
                userChoice.equals("scissors") && computerMove.equals("paper")) {
            return "user";
        }
        else {
            return "computer";
        }
    }

    public void playGame(){
        int userScore = 0;
        int computerScore = 0;

        while (true){
            String userChoice = getUserChoice();
            String computerMove = getComputerChoice();

            JOptionPane.showMessageDialog(null,"The computer chose: " + computerMove);

            String winner = getWinner(userChoice, computerMove);

            if (winner.equals("tie")){
                JOptionPane.showMessageDialog(null, "It's a tie! \n");
            }
            else if(winner.equals("user")) {
                userScore++;
                JOptionPane.showMessageDialog(null, "You win this round!");
            }
            else {
                computerScore++;
                JOptionPane.showMessageDialog(null, "The computer wins this round!");
            }

            JOptionPane.showMessageDialog(null,"Your Score: " + userScore + "| Computer Score " + computerScore);

            if (userScore==3){
                JOptionPane.showMessageDialog(null,"You are the winner!");
                break;
            } else if (computerScore==3) {
                JOptionPane.showMessageDialog(null, "The computer wins!");
                break;
            }
        }
    }

    public void replayPrompt(){

        while (true) {
            JOptionPane.showMessageDialog(null, "=== New Game! First to 3 wins! ===");
            playGame();

            String replay = JOptionPane.showInputDialog("Do you want to play again? (yes/no)");
            if (!replay.trim().equalsIgnoreCase("yes")) {
                JOptionPane.showMessageDialog(null,"Thanks for playing!");
                break;
            }
        }
    }

    public static void main(String[] args){
        GamePopup game = new GamePopup();
        game.replayPrompt();
    }
}
