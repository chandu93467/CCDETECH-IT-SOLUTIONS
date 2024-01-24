import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        int maxAttempts = 10;
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a random number between 1 and 100. Try to guess it.");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (userGuess == targetNumber) {
                System.out.println("Congratulations! You guessed the correct number " + targetNumber + " in "
                        + (attempts + 1) + " attempts.");
                break;
            } else if (userGuess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }

            attempts++;
        }

        if (attempts == maxAttempts) {
            System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber + ".");
        }

        scanner.close();
    }
}
