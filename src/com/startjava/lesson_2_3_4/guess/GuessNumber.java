package com.startjava.lesson_2_3_4.guess;

import java.lang.Math;
import java.util.Scanner;

public class GuessNumber {

    private final Player[] players;
    private final int MIN = 1;
    private final int MAX = 100;
    private final int MAX_ROUNDS = 3;
    private int secretNumber;

    public GuessNumber(Player... players) {
        this.players = players;
    }

    public void start() {
        System.out.println("У каждого игрока по 10 попыток.");
        castLots();

        for (int round = 1; round <= MAX_ROUNDS; round++) {
            secretNumber = MIN + (int) (Math.random() * (MAX - MIN + 1));
            playRound();
            showAnswers();
            clearAnswers();
            resetAttempts();
        }

        showWinner();
        resetScore();
    }

    private void castLots() {
        for (int i = players.length - 1; i > 0; i--) {
            int randomIndex = (int) (Math.random() * (i + 1));
            if (randomIndex == i) continue;
            Player tmp = players[randomIndex];
            players[randomIndex] = players[i];
            players[i] = tmp;
        }
        System.out.println("Игроками брошен жребий.");
    }

    private void playRound() {
        while (hasAttempts()) {
            for (Player player : players) {
                inputNumber(player);
                if (guessNumber(player)) {
                    return;
                }
            }
        }
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

    private void resetAttempts() {
        for (Player player : players) {
            player.resetAttempts();
        }
    }

    private void showWinner() {
        Player winner = determineWinner();
        System.out.printf("В игре по итогам %d раундов %s.%n",
                MAX_ROUNDS, winner == null ? "никто не победил" : "победил " + winner);
    }

    private void resetScore() {
        for (Player player : players) {
            player.resetScore();
        }
    }

    private boolean hasAttempts() {
        for (Player player : players) {
            if (player.hasAttempts()) {
                return true;
            }
        }
        return false;
    }

    private void inputNumber(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%s называет число: ", player);

        while (true) {
            int answer = scanner.nextInt();
            scanner.nextLine();

            if (player.addAnswer(answer, MIN, MAX)) {
                return;
            }

            System.out.printf("Введите число в диапазоне [%d, %d]: ", MIN, MAX);
        }
    }

    private boolean guessNumber(Player player) {
        int number = player.getLastAnswer();

        if (number == secretNumber) {
            System.out.printf("Игрок %s угадал число %d c %d попытки%n",
                    player, secretNumber, player.getNumberAttempts());
            player.upScore();
            return true;
        }

        if (!player.hasAttempts()) {
            System.out.printf("У %s закончились попытки%n", player);
        }

        System.out.printf("Число %d " + (number > secretNumber ? "больше" : "меньше")
                + " того, что загадал компьютер.%n", number);
        return false;
    }

    public Player determineWinner() {
        Player winner = null;

        for (int i = MAX_ROUNDS; i >= 0; i--) {
            if (winner != null) {
                return winner;
            }

            for (Player player : players) {
                if (player.getScore() != i) continue;
                if (i >= MAX_ROUNDS / 2 + 1) {
                    return player;
                }
                if (winner == null) {
                    winner = player;
                } else {
                    return null;
                }
            }
        }

        return winner;
    }
}