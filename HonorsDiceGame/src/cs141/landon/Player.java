/*
Programmer Name: Landon Davidson
Section: 27258
Program Name: Player

Description: This program creates a Player object with the properties name and score.
It also has a method called getGuess that prompts the user for an input and
returns that value.
*/

package cs141.landon;

import java.util.Scanner;

public class Player {
    Scanner input = new Scanner(System.in);
    private final String name;
    private int score;
    public Player() {
        System.out.print("What is your name? ");
        name = input.next();
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addScore() {
        score++;
    }

    public int getGuess() {
        int guess;
        do {
            System.out.format("What is your guess %s (1-6)? ", name);
            guess = input.nextInt();
        } while (!(guess > 0 && guess < 7));
        return guess;
    }
}
