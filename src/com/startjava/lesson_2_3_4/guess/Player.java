package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {

    private final String name;
    private final int[] numbers = new int[10];

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int[] allAnswers() {
        int length = 0;
        for (int num : numbers) {
            if (num != 0) {
                length++;
            }
        }
        return Arrays.copyOf(numbers, length);
    }

    public void addAnswer(int number) {
        numbers[allAnswers().length] = number;
    }

    public int lastAnswer() {
        return numbers[allAnswers().length - 1];
    }

    public boolean remainedAttempt() {
        return allAnswers().length < numbers.length;
    }

    public void clearAnswers() {
        Arrays.fill(numbers, 0, allAnswers().length, 0);
    }

    public void showAnswers() {
        for (int answer : allAnswers()) {
            System.out.printf("%3d", answer);
        }
        System.out.println();
    }
}