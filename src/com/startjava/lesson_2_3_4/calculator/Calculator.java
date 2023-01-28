package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    public static double calculate(String expression) {
        String[] expressionParts = expression.split(" ");
        int factor1 = Integer.parseInt(expressionParts[0]);
        int factor2 = Integer.parseInt(expressionParts[2]);
        String operation = expressionParts[1];

        if (factor1 <= 0 || factor2 <= 0) {
            throw new UnsupportedOperationException("Операции возможны только с положительными числами.");
        }

        return switch (operation) {
            case "+" -> Math.addExact(factor1, factor2);
            case "-" -> Math.subtractExact(factor1, factor2);
            case "*" -> Math.multiplyExact(factor1, factor2);
            case "/" -> (double) factor1 / factor2;
            case "^" -> Math.pow(factor1, factor2);
            case "%" -> Math.IEEEremainder(factor1, factor2);
            default ->  throw new UnsupportedOperationException("Введена неверная математическая операция");
        };
    }
}