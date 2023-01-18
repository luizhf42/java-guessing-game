package numberguessinggame;

import java.util.Scanner;

public class NumberGuessingGame {
    final byte min = 1;
    byte max = 100;
    byte chances = 6;
    int answer;
    Scanner scanner = new Scanner(System.in);

    public void startGame() {
        // passing 101 to include 100 in the possible numbers
        this.answer = NumberGenerator.generateRandomNumber((byte) (max + 1));
        ask();
    }

    private void ask() {
        System.out.printf("Make a guess from %d to %d: ", min, max);
        byte guess = scanner.nextByte();
        handleGuess(guess);
    }

    private void handleGuess(byte guess) {
        if (guess < 1 || guess > 100) {
            System.out.println("Invalid number!");
            ask();
        } else checkAnswer(guess);
    }

    private void checkAnswer(byte guess) {
        if (guess == answer) {
            System.out.println(endGame(true));
        } else {
            System.out.println(showHint(guess) + "\n");
            chances--;
            checkChances();
        }
    }

    private String showHint(short guess) {
        return guess > answer ? "Your guess was too high." : "Your guess was too low.";
    }

    private void checkChances() {
        if (chances > 0) {
            System.out.printf("Now you have %d chances. \n", chances);
            ask();
        } else System.out.println(endGame(false));
    }

    private String endGame(boolean won) {

        return won ? "You guessed it! Congrats!" : String.format("You have no remaining chances. You lose! \nThe " +
                "answer is %d.", answer);
    }
}

