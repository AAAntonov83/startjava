package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя первого участника: ");
        String name = scanner.nextLine();
        Player player1 = new Player(name);
        
        System.out.print("Введите имя второго участника: ");
        name = scanner.nextLine();
        Player player2 = new Player(name);

        System.out.println("У каждого игрока по 10 попыток.");
        String answer = "yes";
        GuessNumber game = new GuessNumber(player1, player2);

        while (!answer.equals("no")) {
            if (answer.equals("yes")) {
                game.start();
            }

            System.out.println("Хотите продолжить игру? [yes/no]");
            answer = scanner.nextLine();
        }
    }
}