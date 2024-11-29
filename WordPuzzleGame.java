import java.util.Scanner;

public class WordPuzzleGame {
    public static void main(String[] args) {
        // Hidden word to guess
        String wordToGuess = "JAVA";
        // Create a char array to hold the current progress
        char[] progress = new char[wordToGuess.length()];
        // Fill the progress array with underscores
        for (int i = 0; i < progress.length; i++) {
            progress[i] = '_';
        }
        // Number of attempts
        int attempts = 6;
        boolean isWordGuessed = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Word Puzzle Game!");
        System.out.println("Guess the word by entering one letter at a time.");
        System.out.println("You have " + attempts + " attempts. Good luck!");

        // Main game loop
        while (attempts > 0 && !isWordGuessed) {
            System.out.println("\nCurrent progress: " + String.valueOf(progress));
            System.out.print("Enter a letter: ");
            char guess = Character.toUpperCase(scanner.next().charAt(0));

            boolean correctGuess = false;

            // Check if the guessed letter is in the word
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    progress[i] = guess;
                    correctGuess = true;
                }
            }

            // Check if the player guessed the whole word
            if (String.valueOf(progress).equals(wordToGuess)) {
                isWordGuessed = true;
            }

            if (correctGuess) {
                System.out.println("Good guess!");
            } else {
                attempts--;
                System.out.println("Wrong guess! You have " + attempts + " attempts left.");
            }
        }

        // Game outcome
        if (isWordGuessed) {
            System.out.println("\nCongratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("\nOut of attempts! The word was: " + wordToGuess);
        }

        scanner.close();
    }
}