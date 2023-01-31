package com.startjava.lesson_2_3_4.guess;

import java.lang.Math;
import java.util.Scanner;

public class GuessNumber {

    private final Player[] players;
    private int secretNumber;
    private final int min = 1;
    private final int max = 100;
    private final int maxRounds = 3;
    private int currentRound = 1;

    public GuessNumber(Player... players) {
        this.players = players;
    }

    public void start() {
        secretNumber = min + (int) (Math.random() * (max - min + 1));
        System.out.println("У каждого игрока по 10 попыток.");
        drawLots();

        while (currentRound <= maxRounds) {
            for (Player player : players) {
                if (player.isAttemptsEnded()) {
                    finishRound();
                    break;
                }
                inputNumber(player);
                if (guessNumber(player)) {
                    finishRound();
                    break;
                }
            }
        }

        finishGame();
    }

    private void drawLots() {
        for (int i = players.length - 1; i > 0; i--) {
            int randomIndex = (int) (Math.random() * (i + 1));
            if (randomIndex == i) {
                continue;
            }
            Player tmp = players[randomIndex];
            players[randomIndex] = players[i];
            players[i] = tmp;
        }
        System.out.println("Игроками брошен жребий.");
    }

    private void finishRound() {
        System.out.printf("Раунд %d окончен.%n", currentRound++);
        showAnswers();
        clearAnswers();
        if (currentRound <= maxRounds) {
            secretNumber = min + (int) (Math.random() * (max - min + 1));
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

    private void inputNumber(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%s называет число: ", player);

        while (true) {
            int answer = scanner.nextInt();
            scanner.nextLine();

            if (player.addAnswer(answer, min, max)) {
                if (player.isAttemptsEnded()) {
                    System.out.printf("У %s закончились попытки%n", player);
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
                    player, secretNumber, player.getNumberAttempts());
            player.addWinPoints();
            return true;
        }

        System.out.printf("Число %d " + (number > secretNumber ? "больше" : "меньше")
                + " того, что загадал компьютер.%n", number);
        return false;
    }

    private void finishGame() {
        currentRound = 1;
        showWinner();
        resetPlayersWinPoints();
    }

    private void showWinner() {
        Player winner = determineWinner();
        System.out.printf("В игре по итогам %d раундов %s.%n",
                maxRounds, winner == null ? "никто не победил" : "победил " + winner);
    }

    public Player determineWinner() {
        Player winner = null;

        for (int i = maxRounds; i >= 0; i--) {
            if (winner != null) {
                return winner;
            }

            for (Player player : players) {
                if (player.getWinPoints() != i) {
                    continue;
                }
                if (i >= maxRounds / 2 + 1) {
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

    private void resetPlayersWinPoints() {
        for (Player player : players) {
            player.resetWinPoints();
        }
    }

}