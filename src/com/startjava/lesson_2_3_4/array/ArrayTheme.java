package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class ArrayTheme {

    public static void main(String[] args) {
        System.out.println("1. Реверс значений массива");
        int[] intsArr = {3, 1, 7, 6, 2, 5, 4};
        int length = intsArr.length;
        showArray(intsArr);

        for (int i = 0; i < length / 2; i++) {
            int buffer = intsArr[i];
            intsArr[i] = intsArr[--length];
            intsArr[length] = buffer;
        }

        showArray(intsArr);

        System.out.println("\n2. Вывод произведения элементов массива");
        intsArr = new int[10];
        length = intsArr.length;

        for (int i = 0; i < length; i++) {
            intsArr[i] = i;
        }

        int result = 1;

        for (int i = 1; i < length - 1; i++) {
            result *= i;
            System.out.print(intsArr[i] + (i < length - 2 ? " * " : " = " + result));
        }

        System.out.printf("\nИндекс: %d, значение: %d%n", 0, intsArr[0]);
        System.out.printf("Индекс: %d, значение: %d%n", 9, intsArr[9]);

        System.out.println("\n3. Удаление элементов массива");
        double[] doubleArr = new double[15];
        length = doubleArr.length;

        for (int i = 0; i < length; i++) {
            doubleArr[i] = Math.random();
        }

        showArray(doubleArr, 8);

        double middleNumber = doubleArr[length / 2 + 1];
        int zeroCounter = 0;
        for (int i = 0; i < length; i++) {
            if (doubleArr[i] > middleNumber) {
                doubleArr[i] = 0;
                zeroCounter++;
            }
        }

        showArray(doubleArr, 8);
        System.out.println("Количество обнуленных ячеек: " + zeroCounter);

        System.out.println("\n4. Вывод элементов массива лесенкой в обратном порядке");
        char[] abc = new char[26];
        length = abc.length;

        for (int i = 0; i < length; i++) {
            abc[i] = (char) ('A' + i);
        }

        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= (length - 1) - i; j--) {
                System.out.print(abc[j]);
            }
            System.out.println();
        }

        System.out.println("\n5. Генерация уникальных чисел");
        int[] uniqueNumbers = new int[30];
        length = uniqueNumbers.length;

        for (int i = 0; i < length; i++) {
            boolean isUnique = true;
            int uniqueNumber = calculateRandom(60, 100);

            for (int j = i - 1; j >= 0; j--) {
                if (uniqueNumbers[j] == uniqueNumber) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                uniqueNumbers[i] = uniqueNumber;
            } else {
                i--;
            }
        }

        //sortArray(intsArr);
        Arrays.sort(uniqueNumbers);
        showArray(uniqueNumbers, 10);

        System.out.println("\n6. Сдвиг элементов массива");
        String[] srcStrings = {"    ", "AA", "", "BBB", "CC", "D", "    ", "E", "FF", "G", ""};
        length = srcStrings.length;

        int emptyStringsNumber = 0;
        for (String string : srcStrings) {
            if (string.isBlank()) {
                emptyStringsNumber++;
            }
        }

        String[] destStrings = new String[length - emptyStringsNumber];

        for (int i = 0, j = 0, k = 0; i < length; i++) {
            boolean isBlank = srcStrings[i].isBlank();
            if (isBlank && j > 0) {
                System.arraycopy(srcStrings, i - j, destStrings, k, j);
                k += j;
                j = 0;
            } else if (!isBlank) {
                j++;
            }
        }

        showArray(srcStrings);
        showArray(destStrings);
    }

    private static void showArray(String[] strings) {
        for (String string : strings) {
            System.out.print(string);
        }
        System.out.println();
    }

    private static void showArray(int[] intArr) {
        for (int num : intArr) {
            System.out.printf("%d ", num);
        }
        System.out.println();
    }

    private static void showArray(int[] intArr, int limit) {
        for (int i = 0; i < intArr.length; i++) {
            if (i > 0 && i % limit == 0) {
                System.out.println();
            }
            System.out.printf("%d ", intArr[i]);
        }
        System.out.println();
    }

    private static void showArray(double[] doubleArr, int limit) {
        for (int i = 0; i < doubleArr.length; i++) {
            if (i > 0 && i % limit == 0) {
                System.out.println();
            }
            System.out.printf("%6.3f", doubleArr[i]);
        }
        System.out.println();
    }

    private static int calculateRandom(int min, int max) {
        return (int) (min + Math.random() * (max - min));
    }

    private static void sortArray(int[] ints) {
        for (int i = ints.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (ints[j] > ints[j + 1]) {
                    int buffer = ints[j + 1];
                    ints[j + 1] = ints[j];
                    ints[j] = buffer;
                }
            }
        }
    }
}