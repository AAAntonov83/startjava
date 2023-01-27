package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer = "yes";

        while (!answer.equals("no")) {
            if (answer.equals("yes")) {
                System.out.print("Введите математическое выражение: ");
                String expression = scanner.nextLine();

                try {
                    double result = Calculator.calculate(expression);
                    System.out.printf("%s = %" + (result % 1 > 0 ? ".3" : ".0") + "f%n", expression, result);
                } catch (NumberFormatException e) {
                    System.out.println("Операции возможны только с целыми числами.");
                } catch (UnsupportedOperationException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("Хотите продолжить вычисления? [yes/no]");
            answer = scanner.nextLine();
        }
    }
}