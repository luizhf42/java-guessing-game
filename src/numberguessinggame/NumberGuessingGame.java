package numberguessinggame;

import java.util.Scanner;

public class NumberGuessingGame {
    private byte chances = 6;
    private int answer;
    private final Scanner scanner = new Scanner(System.in);

    public void startGame() {
        // passing 101 to include 100 in the possible numbers
        this.answer = NumberGenerator.generateRandomNumber((byte) 101);
        askNumber();
    }

    private void askNumber() {
        while (true) {
            try {
                System.out.print("Make a guess from 1 to 100: ");
                int guess = scanner.nextInt();
                handleGuess(guess);
                break;
            } catch (Exception InputMismatchException) {
                System.out.println("Invalid input!");
                scanner.next();
            }
        }
    }

    private void handleGuess(int guess) {
        if (guess < 1 || guess > 100) {
            System.out.println("Invalid number!");
            askNumber();
        } else checkAnswer(guess);
    }

    private void checkAnswer(int guess) {
        if (guess == answer) {
            System.out.println(endGame(true));
        } else {
            System.out.println(showHint(guess) + "\n");
            chances--;
            checkChances();
        }
    }

    private String showHint(int guess) {
        return guess > answer ? "Your guess was too high." : "Your guess was too low.";
    }

    private void checkChances() {
        if (chances > 0) {
            System.out.printf("Now you have %d chances. \n", chances);
            askNumber();
        } else System.out.println(endGame(false));
    }

    private String endGame(boolean won) {
        return won ? "You guessed it! Congrats!" : String.format("You have no remaining chances. You lose! \nThe " +
                "answer is %d.", answer);
    }
}

