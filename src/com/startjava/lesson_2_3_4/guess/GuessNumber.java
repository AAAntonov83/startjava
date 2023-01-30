package com.startjava.lesson_2_3_4.guess;

import java.lang.Math;
import java.util.Scanner;

public class GuessNumber {

    private final Player[] players;
    private final Player[] winners;
    private int secretNumber;
    private final int min = 1;
    private final int max = 100;
    private final int maxRounds = 3;
    private int currentRound;

    public GuessNumber(Player... players) {
        this.players = players;
        winners = new Player[maxRounds];
    }

    public void start() {
        currentRound = 1;
        drawLots();
        startRound();

        while (currentRound <= maxRounds) {
            for (Player player : players) {
                if (player.attemptsEnded()) {
                    finishRound();
                    break;
                }
                inputNumber(player);
                if (guessNumber(player)) {
                    winners[currentRound - 1] = player;
                    finishRound();
                    break;
                }
            }
        }

        showWinner();
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
                if (player.attemptsEnded()) {
                    System.out.printf("У %s закончились попытки%n", player.getName());
                }
                return;
            }
            System.out.printf("Введите число в диапазоне [%d, %d]: ", min, max);
        } 
    }

    private void startRound() {
        secretNumber = min + (int) (Math.random() * (max - min + 1));
    }

    private void finishRound() {
        System.out.printf("Раунд %d окончен.%n", currentRound++);
        showAnswers();
        clearAnswers();
        if (currentRound <= maxRounds) {
            startRound();
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

    public void showWinner() {
        Player winner = getWinner();
        System.out.printf("В игре %s.%n", winner == null ? "никто не победил" :  "победил " + winner.getName());
    }

    private Player getWinner() {
        //Определяем кол-во побед игроков и макс. кол-во побед
        int[] points = new int[maxRounds];
        int maxPoints = 0;
        for (int i = 0; i < players.length; i++) {
            for (Player winner : winners) {
                if (players[i] == winner) {
                    points[i]++;
                }
            }
            maxPoints = Math.max(maxPoints, points[i]);
        }

        if (maxPoints == 0) {
            return null;
        }

        //Количество игроков с максимальным количеством побед
        int maxPointsNumber = 0;
        int winnerIndex = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i] == maxPoints) {
                maxPointsNumber++;
                winnerIndex = i;
            }
        }
        if (maxPointsNumber > 1) {
            return null;
        }

        return players[winnerIndex];
    }
}