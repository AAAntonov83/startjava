package com.startjava.lesson_2_3.calculator;

import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer = "yes";

        while (!answer.equals("no")) {
            System.out.print("Введите первое число: ");
            int number1 = scanner.nextInt();
            System.out.print("Введите знак математической операции: ");
            char operation = scanner.next().charAt(0);
            System.out.print("Введите второе число: ");
            int number2 = scanner.nextInt();

            Calculator calculator = new Calculator();
            System.out.printf("%d %c %d = %d%n",
                    number1, operation, number2, calculator.calculate(number1, number2, operation));

            do {
                System.out.println("Хотите продолжить вычисления? [yes/no]");
                answer = scanner.next();
            } while (!answer.equals("yes") && !answer.equals("no"));
        }
    }
}