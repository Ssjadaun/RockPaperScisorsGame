import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    String[] options = {"Rock", "Paper", "Scissors"};

    System.out.println("Welcome to Rock, Paper, Scissors!");

    int userScore = 0;
    int computerScore = 0;

    while (true) {
      System.out.println("\nChoose your weapon:");
      for (int i = 0; i < options.length; i++) {
        System.out.println("  (" + (i + 1) + ") " + options[i]);
      }
      System.out.print("> ");

      int userChoice;
      try {
        userChoice = scanner.nextInt() - 1;
      } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter a number (1-3).");
        scanner.nextLine(); // Clear the scanner buffer
        continue;
      }

      if (userChoice < 0 || userChoice >= options.length) {
        System.out.println("Invalid choice. Please try again.");
        continue;
      }

      int computerChoice = random.nextInt(options.length);

      System.out.println("\nYou chose: " + options[userChoice]);
      System.out.println("Computer chose: " + options[computerChoice]);

      int result = (userChoice + 1) % 3; // Simplified win/lose logic

      if (result == computerChoice) {
        System.out.println("It's a tie!");
      } else if ((result + 1) % 3 == computerChoice) {
        System.out.println("You win!");
        userScore++;
      } else {
        System.out.println("You lose!");
        computerScore++;
      }

      System.out.println("\nYour score: " + userScore);
      System.out.println("Computer score: " + computerScore);

      System.out.println("\nPlay again? (y/n)");
      String playAgain = scanner.next();
      if (!playAgain.equalsIgnoreCase("y")) {
        break;
      }
    }

    System.out.println("\nThanks for playing!");
    scanner.close();
  }

  @Override
  public String toString() {
    return "RockPaperScissors []";
  }
}

