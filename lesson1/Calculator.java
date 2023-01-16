public class Calculator {

    public static void main(String[] args) {
        int firstNumber = 4;
        int secondNumber = 4;
        int result = 0;
        char sign = '*';

        if (sign == '+') {
            result = firstNumber + secondNumber;
        } else if (sign == '-') {
            result = firstNumber - secondNumber;
        } else if (sign == '*') {
            result = firstNumber * secondNumber;
        } else if (sign == '/') {
            result = firstNumber / secondNumber;
        } else if (sign == '^') {
            result = firstNumber;
            for (int i = 1; i < secondNumber; i++) {
                result *= firstNumber;
            }
        } else if (sign == '%') {
            result = firstNumber % secondNumber;
        }

        System.out.printf("%d %c %d = %d%n", firstNumber, sign, secondNumber, result);
    }
}