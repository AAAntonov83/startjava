package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    public static double calculate(int number1, int number2, String operation) throws Exception {
        return switch (operation) {
            case "+" -> Math.addExact(number1, number2);
            case "-" -> Math.subtractExact(number1, number2);
            case "*" -> Math.multiplyExact(number1, number2);
            case "/" -> (double) number1 / number2;
            case "^" -> Math.pow(number1, number2);
            case "%" -> Math.IEEEremainder(number1, number2);
            default ->  throw new Exception("Введена неверная математическая операция");
        };
    }
}