package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer = "yes";

        while (!answer.equals("no")) {
            if (answer.equals("yes")) {
                System.out.print("Введите математическое выражение: ");
                String expString = scanner.nextLine();
                String[] expression = expString.split(" ");
                Calculator calculator = new Calculator();

                double result = calculator.calculate(Integer.parseInt(expression[0]),
                        Integer.parseInt(expression[2]), expression[1]);
                System.out.printf("%s %s %s = %" + (result % 1 > 0 ? ".3" : ".0") + "f%n",
                        expression[0], expression[1], expression[2], result);
            }
            System.out.println("Хотите продолжить вычисления? [yes/no]");
            answer = scanner.nextLine();
        }
    }
}