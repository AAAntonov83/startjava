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
        int remainder = num4 % 10;
        int sum = 0;

        while (num4 > 0) { 
            num4 /= 10;
            System.out.print(remainder);
            sum += remainder;
            remainder = num4 % 10;
        }

        System.out.println("\n" + sum);

        System.out.println("\n4. Вывод чисел на консоль в несколько строк");
        //int limit = 24;

        // for (int i = 1, j = 1; true; i += 2, j++) {
        //     if (i >= limit && j % 5 == 1) {
        //         break;
        //     }
        //     if (i > limit) {
        //         System.out.printf("%4d", 0);
        //     } else {
        //         System.out.printf("%4d", i);
        //     }
        //     if (j % 5 == 0) {
        //         System.out.print("\n");
        //     }
        // }

        int limit = 24;
        int columnMax = 5;
        int columnCounter = 1;

        for (int i = 1; true; i += 2) {
            if (i >= limit && columnCounter % 5 == 1) {
                break;
            }
            if (i < limit) {
                System.out.printf("%4d", i);
            } else {
                System.out.printf("%4d", 0);
            }
            if (columnCounter % columnMax == 0) {
                System.out.print("\n");
                columnCounter = 1;
            } else {
                columnCounter++;
            }
        }

        System.out.println("\n5. Проверка количества двоек на четность/нечетность");
        int num5 = 3242592;
        int copyNum5 = num5;
        int counterTwos = 0;

        while (copyNum5 > 0) {
            if (copyNum5 % 10 == 2) {
                counterTwos++;
            }
            copyNum5 /= 10;
        }

        System.out.printf("Число %d содержит %s количество двоек.%n",
                num5, (counterTwos % 2) == 0 ? "четное" : "нечетное");

        System.out.println("\n6. Отображение фигур в консоли");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        System.out.println("");

        int columnCounter2 = 5;
        int columnLimit = 5;
        while (columnLimit-- > 0) {
            while (columnCounter2-- > 0) {
                System.out.print("#");
            }
            System.out.println("");
            columnCounter2 = columnLimit;
        }
        System.out.println("");
        
        columnCounter = 1;
        columnLimit = 1;
        int columnMax2 = 3;
        boolean growing = true;

        do {
            do {
                System.out.print("$");
            } while (++columnCounter <= columnLimit);
            System.out.println("");
            if (columnLimit == columnMax2) {
                growing = false;
            }
            if (growing) {
                columnLimit++;
            } else {
                columnLimit--;
            }
            columnCounter = 1;
        } while (columnLimit > 0);

        System.out.println("\n7. Отображение ASCII-символов");
        System.out.printf("%4s %4s%n", "DEC", "Char");

        for (char sym = '\u0000'; sym < '\u0127'; sym++) {
            if (sym < 48 && sym % 2 != 0) {
                System.out.printf("%4d %4c%n", (byte) sym, sym);
            } else if (sym >= 97 && sym <= 122 && sym % 2 == 0) {
                System.out.printf("%4d %4c%n", (byte) sym, sym);
            }
        }

        System.out.println("\n8. Проверка, является ли число палиндромом");
        int origin = 1234321;
        int length = 0;
        int avers = origin;
        int revers = origin;
        int aversLength = 0;
        boolean isPalindrome = true;

        while ((avers /= 10) != 0) {
            length++;
        }
        avers = origin;
        aversLength = length;

        for (int i = 1; i <= length / 2; i++) {
            for (int j = 1; j <= aversLength; j++) {
                avers /= 10;
            }

            if (avers / 10 > 0) {
                avers %= 10;
            }
            aversLength--;

            if (avers != revers % 10) {
                isPalindrome = false;
                break;
            } else {
                revers /= 10;
                avers = origin;
            }
        }

        System.out.printf("Число %d %s является палиндромом%n", origin, isPalindrome ? "" : "не");

        System.out.println("\n9. Определение, является ли число счастливым");
        int origin2 = 123321;
        int length2 = 0;
        int avers2 = origin2;
        int revers2 = origin2;
        boolean isHappyNumber = true;

        while ((avers2 /= 10) != 0) {
            length2++;
        }
        avers2 = origin2;

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= length2; j++) {
                avers2 /= 10;
            }

            if (avers2 / 10 > 0) {
                avers2 %= 10;
            }

            length2--;

            if (avers2 != revers2 % 10) {
                isHappyNumber = false;
                break;
            } else {
                revers2 /= 10;
                avers2 = origin2;
            }
        }

        System.out.printf("Число %d %s является счастливым%n", origin2, isHappyNumber ? "" : "не");

        System.out.println("\n10. Вывод таблицы умножения Пифагора");
        boolean drawnVertical = false;
        boolean drawnHorizontal = false;

        System.out.println("     ТАБЛИЦА     ПИФАГОРА");

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i == 1 && j == 1) {
                    System.out.print("   ");
                } else if (j == 2 && !drawnVertical) {
                    System.out.print("|");
                    drawnVertical = true;
                    j--;
                } else if (i == 2 && !drawnHorizontal) {
                    System.out.print("---");
                    if (j == 9){
                        i--;
                        drawnHorizontal = true;
                    }
                } else {
                    System.out.printf("%3d", i * j);
                }
            }
            System.out.println("");
            drawnVertical = false;
        }
        System.out.println("");
    }
}