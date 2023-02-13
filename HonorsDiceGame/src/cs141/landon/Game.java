/*
Programmer Name: Landon Davidson
Section: 27258
Program Name: Game

Description: This program takes amountOfPlayers and scoreToWin as an input and stores
the variables turnNum, scoreToWin, and an array of Player objects. The constructor
creates amountOfPlayers amount of Player objects and stores them inside the players array.
It has the methods takeTurn(), checkForWin(), and printAccuracyRate(). takeTurn() generates
a random number for each player and calls Player.getGuess(). If the players guess matches
the number it awards the player a point. checkForWin() compares all the players scores
to scoreToWin, if any player has a winning score it announces the winner and exits.
printAccuracyRate() divides each player's score by turnNums to find what percent of guesses
were right and prints it.
 */

package cs141.landon;

import java.util.Random;

public class Game {
    Random rand = new Random();
    private Player[] players;
    private final int scoreToWin;
    private int turnNum = 0;
    public Game(int amountOfPlayers, int scoreToWin) {
        this.scoreToWin = scoreToWin;
        players = new Player[amountOfPlayers];
        for (int i = 0; i < amountOfPlayers; i++) {
            players[i] = new Player();
        }
    }
    public boolean checkForWin() {
        for (Player player : players) {
            if (player.getScore() >= scoreToWin) {
                System.out.println(player.getName() + " won the game!\n");
                return true;
            }
        }
        return false;
    }
    public void takeTurn() {
        turnNum++;
        System.out.println("\nTurn Number " + turnNum + "\n");
        int diceRoll;
        for (Player player : players) {
            diceRoll = rand.nextInt(6) + 1;
            if (player.getGuess() == diceRoll) {
                System.out.format("Congratulations %s, you guessed the correct answer!%n", player.getName());
                player.addScore();
            } else {
                System.out.println("Sorry, that's wrong " + player.getName() + ". The answer was " + diceRoll);
            }
        }
        System.out.println();
        for (Player player : players) {
            System.out.println(player.getName() + " your score is " + player.getScore());
        }
    }
    public void printAccuracyRate() {
        double accuracyRate;
        System.out.println();
        for (Player player : players) {
            accuracyRate = player.getScore() / (double) turnNum;
            System.out.println(player.getName() + " your accuracy rate was " + (int) (accuracyRate * 100) + "%");
        }
    }
}
