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
                    Calculator.calculate(expression);
                } catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Введено некорректное выражение.");
                    continue;
                } catch (NumberFormatException e){
                    System.out.println("Математические операции вычисляются только с целыми числами.");
                    continue;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    continue;
                }
            }
            System.out.println("Хотите продолжить вычисления? [yes/no]");
            answer = scanner.nextLine();
        }
    }
}