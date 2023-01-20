package com.startjava.lesson_1.advanced;

public class MyFirstGame {

    public static void main(String[] args) {
        int secretNumber = 77;
        int playerNumber = 88;

        while (playerNumber != secretNumber) {
            if (playerNumber < secretNumber) {
                System.out.printf("Число %d меньше того, что загадал компьютер%n", playerNumber);
                playerNumber++;
            } else {
                System.out.printf("Число %d больше того, что загадал компьютер%n", playerNumber);
                playerNumber--;
            }
        }
        System.out.println("Вы победили!");
    }
}