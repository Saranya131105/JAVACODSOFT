import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess the number between 1 and 100.");

        while (playAgain) {
            int generatedNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10; 
            boolean guessedCorrectly = false;

            System.out.println("\nNew Round! You have a maximum of 10 attempts to guess the number.");

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
                int guess;
                
                
                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    continue;
                }

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                attempts++;

                if (guess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number " + generatedNumber + " in " + attempts + " attempts.");
                    int score = maxAttempts - attempts + 1;  // Higher score for fewer attempts
                    totalScore += score;
                    System.out.println("You scored " + score + " points this round.");
                    guessedCorrectly = true;
                    break;
                } else if (guess < generatedNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts! The correct number was " + generatedNumber + ".");
            }

            System.out.println("Your total score so far: " + totalScore);

            
            System.out.print("\nWould you like to play another round? (yes/no): ");
            String playAgainInput = scanner.nextLine().trim().toLowerCase();

            playAgain = playAgainInput.equals("yes") || playAgainInput.equals("y");
        }

        System.out.println("\nGame Over! Your final score is " + totalScore + ". Thanks for playing!");
        scanner.close();
    }
}
