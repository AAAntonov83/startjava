package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {

    private final String name;
    private int numberAttempts;
    private int score;
    private final int[] answers = new int[10];

    public Player(String name) {
        this.name = name;
    }

    public int getNumberAttempts() {
        return numberAttempts;
    }

    public int getScore() {
        return score;
    }

    public int[] getAnswers() {
        return Arrays.copyOf(answers, numberAttempts);
    }

    public int getLastAnswer() {
        return answers[numberAttempts - 1];
    }

    public boolean addAnswer(int answer, int min, int max) {
        if (answer >= min && answer <= max) {
            answers[numberAttempts++] = answer;
            return true;
        }
        return false;
    }

    public void clearAnswers() {
        Arrays.fill(answers, 0, numberAttempts, 0);
        numberAttempts = 0;
    }

    public boolean hasAttempts() {
        return answers.length > numberAttempts;
    }

    public void upScore() {
        score++;
    }

    public void resetScore() {
        score = 0;
    }

    @Override
    public String toString() {
        return name;
    }
}