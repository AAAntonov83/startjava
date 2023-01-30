package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {

    private final String name;
    private int attemptsNumber;
    private final int[] answers = new int[10];

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAttemptsNumber() {
        return attemptsNumber;
    }

    public int[] getAnswers() {
        return Arrays.copyOf(answers, attemptsNumber);
    }

    public int getLastAnswer() {
        return answers[attemptsNumber - 1];
    }

    public boolean addAnswer(int answer, int min, int max) {
        if (answer >= min && answer <= max) {
            answers[attemptsNumber++] = answer;
            return true;
        }
        return false;
    }

    public boolean attemptsEnded() {
        return attemptsNumber == answers.length;
    }

    public void clearAnswers() {
        Arrays.fill(answers, 0, attemptsNumber, 0);
        attemptsNumber = 0;
    }
}