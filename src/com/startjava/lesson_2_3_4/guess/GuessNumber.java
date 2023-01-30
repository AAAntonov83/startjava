package com.startjava.lesson_2_3_4.guess;

import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;

public class GuessNumber {

    private Player[] players;
    private int secretNumber;
    private final int min = 1;
    private final int max = 100;

    public GuessNumber(Player... players) {
        this.players = players;
    }

    public void start() {
        secretNumber = min + (int) (Math.random() * (max - min + 1));
        drawLots();

        boolean gameOver = false;
        while (!gameOver) {
            for (Player player : players) {
                if (!player.remainedAttempt()) {
                    gameOver = true;
                    break;
                }

                inputNumber(player);

                if (guessNumber(player)) {
                    gameOver = true;
                    break;
                }
            }
        }

        showAnswers();
        clearAnswers();

    }

    private void drawLots() {
        for (int i = players.length - 1; i >= 0; i--) {
            int randomIndex = (int) (Math.random() * (i + 1));
            if (randomIndex == i) {
                continue;
            }
            Player tmp = players[randomIndex];
            System.arraycopy(players, randomIndex + 1, players, randomIndex, i - randomIndex);
            players[i] = tmp;
        }

        System.out.println("Брошен жребий.");
    }

    private void inputNumber(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%s называет число: ", player.getName());

        while (true) {
            int answer = scanner.nextInt();
            scanner.nextLine();

            if (player.addAnswer(answer, min, max)) {
                if (!player.remainedAttempt()) {
                    System.out.printf("У %s закончились попытки%n", player.getName());
                }
                return;
            }
            System.out.printf("Введите число в диапазоне [%d, %d]: ", min, max);
        } 
    }

    private boolean guessNumber(Player player) {
        int number = player.getLastAnswer();

        if (number == secretNumber) {
            System.out.printf("Игрок %s угадал число %d c %d попытки%n",
                    player.getName(), secretNumber, player.getAttemptsNumber());
            return true;
        }

        System.out.printf("Число %d " + (number > secretNumber ? "больше" : "меньше")
                + " того, что загадал компьютер.%n", number);
        return false;
    }

    private void showAnswers() {
        for (Player player : players) {
            for (int answer : player.getAnswers()) {
                System.out.printf("%3d", answer);
            }
            System.out.println();
        }
    }

    private void clearAnswers() {
        for (Player player : players) {
            player.clearAnswers();
        }
    }
}