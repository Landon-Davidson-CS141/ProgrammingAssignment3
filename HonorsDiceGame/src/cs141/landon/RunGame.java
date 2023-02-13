/*
Programmer Name: Landon Davidson
Section: 27258
Program Name: Game

Description: This program prompts the user for how many players are in the game and what
the winning score will be. It then passes those values to Game. After that the program
just repeatedly calls Game.takeTurn() until checkForWin() returns as true.
*/
package cs141.landon;

import java.util.Scanner;

public class RunGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many people are playing? ");
        int amountOfPlayers = input.nextInt();
        System.out.print("How many points will it take to win? ");
        int scoreToWin = input.nextInt();
        System.out.println();

        Game obj = new Game(amountOfPlayers, scoreToWin);
        boolean won = false;

        while (!won) {
            obj.takeTurn();
            won = obj.checkForWin();
        }
        obj.printAccuracyRate();
    }
}
