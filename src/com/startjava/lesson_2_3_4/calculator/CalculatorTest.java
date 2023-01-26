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

                try {
                    int factor1 = Integer.parseInt(expression[0]);
                    int factor2 = Integer.parseInt(expression[2]);

                    if (factor1 < 0 || factor2 < 0) {
                        throw new Exception("Математические операции только с положительными числами.");
                    }

                    double result = Calculator.calculate(Integer.parseInt(expression[0]),
                            Integer.parseInt(expression[2]), expression[1]);
                    System.out.printf("%s %s %s = %" + (result % 1 > 0 ? ".3" : ".0") + "f%n",
                            expression[0], expression[1], expression[2], result);
                } catch (IndexOutOfBoundsException e){
                    System.out.println("Ввод некорректен.");
                } catch (NumberFormatException e){
                    System.out.println("Математические операции вычисляются только с целыми числами.");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("Хотите продолжить вычисления? [yes/no]");
            answer = scanner.nextLine();
        }
    }
}