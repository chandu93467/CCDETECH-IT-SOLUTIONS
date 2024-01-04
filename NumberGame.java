import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        playNumberGame();
    }

    public static void playNumberGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int roundsPlayed = 0;

        while (true) {
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int roundScore = 0;

            System.out.println("\nRound " + (roundsPlayed + 1) + ": Guess the number between 1 and 100");

            while (true) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    roundScore = 100 - (attempts - 1) * 5;
                    totalScore += roundScore;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

                if (attempts == 10) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was "
                            + targetNumber + ".");
                    break;
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                break;
            }

            roundsPlayed++;
        }

        System.out.println("\nGame over. Total score: " + totalScore);

        scanner.close();
    }
}
