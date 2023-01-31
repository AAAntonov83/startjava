package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Player[] players = new Player[3];
        for (int i = 0; i < players.length; i++) {
            System.out.printf("Введите имя участника №%d: ", i + 1);
            String name = scanner.nextLine();
            players[i] = new Player(name);
        }

        String answer = "yes";
        GuessNumber game = new GuessNumber(players);

        while (!answer.equals("no")) {
            if (answer.equals("yes")) {
                game.start();
            }

            System.out.println("Хотите продолжить игру? [yes/no]");
            answer = scanner.nextLine();
        }
    }
}