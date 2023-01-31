package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {

    private static final int NUMBER_PLAYERS = 3;

    public static void main(String[] args) {
        GuessNumber game = new GuessNumber(createPlayers());
        String answer = "yes";

        while (!answer.equals("no")) {
            if (answer.equals("yes")) {
                game.start();
            }

            System.out.println("Хотите продолжить игру? [yes/no]");
            Scanner scanner = new Scanner(System.in);
            answer = scanner.nextLine().strip();
        }
    }

    private static Player[] createPlayers() {
        Scanner scanner = new Scanner(System.in);
        Player[] players = new Player[NUMBER_PLAYERS];

        for (int i = 0; i < players.length; i++) {
            System.out.printf("Введите имя участника №%d: ", i + 1);
            String name = scanner.nextLine().strip();
            players[i] = new Player(name);
        }

        return players;
    }
}