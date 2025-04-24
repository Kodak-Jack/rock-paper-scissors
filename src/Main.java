import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public String getUserChoice(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose: rock, paper or scissors");
        String userChoice = scanner.nextLine().toLowerCase().trim();
        return userChoice;
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

            System.out.println("The computer chose: " + computerMove);

            String winner = getWinner(userChoice, computerMove);

            if (winner.equals("tie")){
                System.out.println("It's a tie! \n");
            }
            else if(winner.equals("user")) {
                userScore++;
                System.out.println("You win this round!");
            }
            else {
                computerScore++;
                System.out.println("The computer wins this round!");
            }

            System.out.println("Your Score: " + userScore + "| Computer Score " + computerScore);
            System.out.println();

            if (userScore==3){
                System.out.println("You are the winner!");
                break;
            } else if (computerScore==3) {
                System.out.println("The computer wins!");
                break;
            }
        }
    }

    public void replayPrompt(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== New Game! First to 3 wins! ===");
            playGame();

            System.out.println("Do you want to play again? (yes/no)");

            String replay = scanner.nextLine();
            if (!replay.equals("yes")) {
                System.out.println("Thanks for playing!");
                break;
            }
        }
    }

    public static void main(String[] args){
        Main game = new Main();
        game.replayPrompt();
        game.playGame();
    }
    }