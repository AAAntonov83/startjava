public class CyclesTheme {

    public static void main(String[] args) {
        System.out.println("1. Подсчет суммы четных и нечетных чисел");
        int sumOdd = 0;
        int sumEven = 0;
        int min = -10;
        int max = 21;
        int counter = min;

        do {
            if (counter % 2 == 0) {
                sumEven += counter;
            } else {
                sumOdd += counter;
            }
        } while (++counter <= max);
        
        System.out.printf("В промежутке [%s, %s] сумма четных чисел = %d, а нечетных = %d%n",
                min, max, sumEven, sumOdd);

        System.out.println("\n2. Вывод чисел в интервале (min и max) в порядке убывания");
        int num1 = 10;
        int num2 = 5;
        int num3 = -1;
        int min2 = 0;
        int max2 = 0;

        if (num1 >= num2) {
            max2 = num1 >= num3 ? num1 : num3;
            min2 = num2 <= num3 ? num2 : num3;
        } else {
            min2 = num1 <= num3 ? num1 : num3;
            max2 = num2 >= num3 ? num2 : num3;
        }

        for (int i = --max2; i > min2; i--) {
            System.out.print(i);
        }

        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр");
        int num4 = 12345;
        int sum = 0;

        while (num4 > 0) { 
            int remainder = num4 % 10;
            System.out.print(remainder);
            sum += remainder;
            num4 /= 10;
        }

        System.out.println("\n" + sum);

        System.out.println("\n4. Вывод чисел на консоль в несколько строк");

        int limit = 24;
        int columnMax = 5;
        int columnCount = 1;

        for (int i = 1; true; i += 2) {
            if (i >= limit && columnCount % columnMax == 1) {
                break;
            }
            if (i < limit) {
                System.out.printf("%4d", i);
            } else {
                System.out.printf("%4d", 0);
            }
            if (columnCount % columnMax == 0) {
                System.out.println();
                columnCount = 1;
            } else {
                columnCount++;
            }
        }

        System.out.println("\n5. Проверка количества двоек на четность/нечетность");
        int num5 = 3242592;
        int copyNum5 = num5;
        int countTwos = 0;

        while (copyNum5 > 0) {
            if (copyNum5 % 10 == 2) {
                countTwos++;
            }
            copyNum5 /= 10;
        }

        System.out.printf("Число %d содержит %s количество двоек.%n",
                num5, (countTwos % 2) == 0 ? "четное" : "нечетное");

        System.out.println("\n6. Отображение фигур в консоли");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        int columnCounter = 5;
        int columnLimit = 5;
        while (columnLimit-- > 0) {
            while (columnCounter-- > 0) {
                System.out.print("#");
            }
            System.out.println();
            columnCounter = columnLimit;
        }
        System.out.println();
        
        columnCounter = 1;
        columnLimit = 1;
        int columnMax2 = 3;

        do {
            do {
                System.out.print("$");
            } while (++columnCounter <= columnLimit);
            System.out.println();
            if (columnLimit >= columnMax2) {
                columnMax2--;
                columnLimit--;
            } else {
                columnLimit++;
            }
            columnCounter = 1;
        } while (columnMax2 > 0);

        System.out.println("\n7. Отображение ASCII-символов");
        System.out.printf("%4s %4s%n", "DEC", "Char");
        for (int i = 0; i < 128 ; i++) {
            if (i < '0' && i % 2 != 0) {
                System.out.printf("%4d %4c%n", i, i);
            } else if (i >= 'a' && i <= 'z' && i % 2 == 0) {
                System.out.printf("%4d %4c%n", i, i);
            }
        }

        System.out.println("\n8. Проверка, является ли число палиндромом");
        int origin = 1234321;
        int copyOrigin = origin;
        int revers = 0;

        while (copyOrigin > 0) { 
            revers = revers * 10 + copyOrigin % 10;
            copyOrigin /= 10;
        }

        System.out.printf("Число %d %s является палиндромом%n",
                origin, origin == revers ? "" : "не");

        System.out.println("\n9. Определение, является ли число счастливым");
        int num6 = 123321;
        int rightHalfNum6 = num6 / 1000;
        int leftHalfNum6 = num6 % 1000;
        int sumRight = 0;
        int sumLeft = 0;

        for (int i = 1; i <= 3; i++) {
            sumLeft += leftHalfNum6 % 10;
            sumRight += rightHalfNum6 % 10;
            rightHalfNum6 /= 10;
            leftHalfNum6 /= 10;
        }

        System.out.printf("Сумма цифр %d = %d%n", num6 / 1000, sumRight);
        System.out.printf("Сумма цифр %d = %d%n", num6 % 1000, sumLeft);
        System.out.printf("Число %d %s является счастливым%n",
                num6, sumRight == sumLeft ? "" : "не");

        System.out.println("\n10. Вывод таблицы умножения Пифагора");
        System.out.println("     ТАБЛИЦА     ПИФАГОРА");

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (i == 1 && j == 1) {
                    System.out.print("   ");
                } else if (j == 2) {
                    System.out.print("|");
                } else if (i == 2 && j != 2) {
                    System.out.print("---");
                } else {
                    int factor1 = i > 2 ? i - 1 : i;
                    int factor2 = j > 2 ? j - 1 : j;
                    System.out.printf("%3d", factor1 * factor2);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}