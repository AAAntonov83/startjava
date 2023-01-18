public class Calculator {

    public int calculate(int number1, int number2, char operation) {
        int result = 0;

        switch (operation) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                result = number1 / number2;
                break;
            case '^':
                result = number1;
                for (int i = 1; i < number2; i++) {
                    result *= number1;
                }
                break;
            case '%':
                result = number1 % number2;
        }

        return result;
    }
}