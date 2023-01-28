package com.startjava.lesson_2_3_4.guess;

import java.lang.Math;
import java.util.Scanner;

public class GuessNumber {

    private Player player1;
    private Player player2;
    private int secretNumber;
    private int min = 1;
    private int max = 100;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        secretNumber = min + (int) (Math.random() * (max - min + 1));
        player1.clearAnswers();
        player2.clearAnswers();

        while (player1.remainedAttempt() && player2.remainedAttempt()) {
            inputNumber(player1);
            if (guessNumber(player1)) {
                break;
            }
            inputNumber(player2);
            if (guessNumber(player2)) {
                break;
            }
        }
        player1.showAnswers();
        player2.showAnswers();
    }

    private void inputNumber(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%s называет число: ", player.getName());

        while (true) {
            int answer = scanner.nextInt();
            scanner.nextLine();

            if (answer >= min && answer <= max) {
                player.addAnswer(answer);
                if (!player.remainedAttempt()) {
                    System.out.printf("У %s закончились попытки%n", player.getName());
                }
                return;
            }
            System.out.printf("Введите число в диапазоне [%d, %d]: ", min, max);
        } 
    }

    private boolean guessNumber(Player player) {
        int number = player.lastAnswer();

        if (number == secretNumber) {
            System.out.printf("Игрок %s угадал число %d c %d попытки%n",
                    player.getName(), secretNumber, player.allAnswers().length);
            return true;
        }

        System.out.printf("Число %d " + (number > secretNumber ? "больше" : "меньше")
                + " того, что загадал компьютер.%n", number);
        return false;
    }
}