import java.util.Arrays;

public class ArrayTheme {

    public static void main(String[] args) {
        System.out.println("1. Реверс значений массива");
        int[] intsArr = {3, 1, 7, 6, 2, 5, 4};

        showArray(intsArr);

        for (int i = 0; i < intsArr.length / 2; i++) {
            int buffer = intsArr[i];
            intsArr[i] = intsArr[(intsArr.length - 1) - i];
            intsArr[(intsArr.length - 1) - i] = buffer;
        }

        showArray(intsArr);

        System.out.println("\n2. Вывод произведения элементов массива");
        intsArr = new int[10];

        for (int i = 0; i < intsArr.length; i++) {
            intsArr[i] = i;
        }

        int result = 1;
        for (int i = 0; i < intsArr.length; i++) {
            result = i > 0 && i < 9 ? result * i : result;
            System.out.print(i == 0 ? intsArr[i] + " " + i + "\n": "");
            System.out.print(i > 0 && i < 8 ? i + " * " : "");
            System.out.print(i == 8 ? i : "");
            System.out.print(i == 9 ? " = " + result + "\n" + intsArr[i] + " " + i + "\n": "");
        }

        System.out.println("\n3. Удаление элементов массива");
        double[] doubleArr = new double[15];

        for (int i = 0; i < doubleArr.length; i++) {
            doubleArr[i] = Math.random();
        }

        showArray(doubleArr, 8);
        System.out.println();

        int middle = doubleArr.length / 2 + 1;
        int zeroCounter = 0;
        for (int i = 0; i < middle; i++) {
            if (doubleArr[i] > doubleArr[middle]) {
                doubleArr[i] = 0;
                zeroCounter++;
            }
        }

        showArray(doubleArr, 7);
        System.out.println(zeroCounter);

        System.out.println("\n4. Вывод элементов массива лесенкой в обратном порядке");
        char[] chars = new char[26];
        for (int i = 0; i < 26; i++) {
            chars[i] = (char) (i + 65);
        }

        for (int i = 0; i < chars.length; i++) {
            for (int j = chars.length - 1; j >= (chars.length - 1) - i; j--) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }

        System.out.println("\n5. Генерация уникальных чисел");
        intsArr = new int[30];
        for (int i = 0; i < intsArr.length; i++) {
            int randomNumber = calculateRandom(60, 100);
            for (int j = 0; j < i; j++) {
                if (intsArr[j] == randomNumber) {
                    randomNumber = calculateRandom(60, 100);
                    j = -1;
                }
            }
            intsArr[i] = randomNumber;
        }

        //sortArray(intsArr);
        Arrays.sort(intsArr);
        showArray(intsArr, 10);

        System.out.println("\n6. Сдвиг элементов массива");
        String[] strings = {"    ", "AA", "", "BBB", "CC", "D", "    ", "E", "FF", "G", ""};
        int emptyNumber = 0;
        for (String string : strings) {
            if (string.isBlank()) {
                emptyNumber++;
            }
        }

        String[] stringsCopy = new String[strings.length - emptyNumber];
        for (int i = 0, j = 0; i < strings.length; i++) {
            if (!strings[i].isBlank()) {
                System.arraycopy(strings, i, stringsCopy, j++, 1);
            }
        }

        showArray(strings);
        showArray(stringsCopy);
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