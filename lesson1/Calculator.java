public class Calculator {

    public static void main(String[] args) {
        int a = 4;
        int b = 4;
        int result = 0;
        char sign = '*';

        if (sign == '+') {
            result = a + b;
        } else if (sign == '-') {
            result = a - b;
        } else if (sign == '*') {
            result = a * b;
        } else if (sign == '/') {
            result = a / b;
        } else if (sign == '^') {
            result = a;
            for (int i = 1; i < b; i++) {
                result *= a;
            }
        } else if (sign == '%') {
            result = a % b;
        }

        System.out.printf("%d %c %d = %d%n", a, sign, b, result);
    }
}