package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    public double calculate(int number1, int number2, String operation) {
        switch (operation) {
            case "+":
                return Math.addExact(number1, number2 );
            case "-":
                return Math.subtractExact(number1, number2) ;
            case "*":
                return Math.multiplyExact(number1, number2);
            case "/":
                return (double) number1 / number2;
            case "^":
                return Math.pow(number1, number2);
            case "%":
                return Math.IEEEremainder(number1, number2);
        }
        return 0;
    }
}