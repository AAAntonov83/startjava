public class VariablesTheme {

    public static void main(String[] args) {
        System.out.println("1. Вывод значений переменных на консоль");
        byte processorCount = 16;
        short streamCount = 24;
        int cpuModel = 12900;
        long maxMemorySize = 128L;
        float cpuFreq = 3.200f;
        double cpuFreqOver = 5.200d;
        char letter = 'K';
        String cpuVendor = "Intel";
        System.out.println("Процессор " + cpuVendor + " " + cpuModel + letter + ", частота "
                + cpuFreq + "GHz, в разгоне " + cpuFreqOver + "GHz, ядер " + processorCount
                + ", потоков " + streamCount + ", максимальный объем оперативной памяти "
                + maxMemorySize + "Gb");

        System.out.println("\n2. Расчет стоимости товара со скидкой");
        int penPrice = 100;
        int bookPrice = 200;
        int discountPercent = 11;
        float diskountSum = (float) discountPercent / 100 * (penPrice + bookPrice);
        float discountPrice = (float) (100 - discountPercent) / 100 * (penPrice + bookPrice);
        System.out.println("Сумма скидки - " + diskountSum);
        System.out.println("Сумма товаров со скидкой - " + discountPrice);

        System.out.println("\n3. Вывод слова JAVA");
        System.out.println("   J    a  V     V  a");
        System.out.println("   J   a a  V   V  a a");
        System.out.println("J  J  aaaaa  V V  aaaaa");
        System.out.println(" JJ  a     a  V  a     a");

        System.out.println("\n4. Вывод min и max значений целых числовых типов");
        byte maxByte = 127;
        System.out.println(maxByte);
        System.out.println(++maxByte);
        System.out.println(--maxByte);

        short maxShort = 32_767;
        System.out.println(maxShort);
        System.out.println(++maxShort);
        System.out.println(--maxShort);

        int maxInt = 2_147_483_647;
        System.out.println(maxInt);
        System.out.println(++maxInt);
        System.out.println(--maxInt);

        long maxLong = 9_223_372_036_854_775_807L;
        System.out.println(maxLong);
        System.out.println(++maxLong);
        System.out.println(--maxLong);

        System.out.println("\n5. Перестановка значений переменных");
        System.out.println("Перестановка через третью переменную.");
        int num1 = 2;
        int num2 = 5;
        System.out.println(num1 + " " + num2);
        int tmp = num2;
        num2 = num1;
        num1 = tmp;
        System.out.println(num1 + " " + num2);

        System.out.println("Перестановка через арифметическую операцию.");
        System.out.println(num1 + " " + num2);
        num1 += num2;
        num2 = num1 - num2;
        num1 -= num2;
        System.out.println(num1 + " " + num2);

        System.out.println("Перестановка через побитовую операцию.");
        System.out.println(num1 + " " + num2);
        num1 ^= num2;
        num2 ^= num1;
        num1 ^= num2;
        System.out.println(num1 + " " + num2);

        System.out.println("\n6. Вывод символов и их кодов");
        char sym1 = '#';
        char sym2 = '&';
        char sym3 = '@';
        char sym4 = '^';
        char sym5 = '_';
        System.out.println(sym1 + " " + (byte) sym1);
        System.out.println(sym2 + " " + (byte) sym2);
        System.out.println(sym3 + " " + (byte) sym3);
        System.out.println(sym4 + " " + (byte) sym4);
        System.out.println(sym5 + " " + (byte) sym5);

        System.out.println("\n7. Вывод в консоль ASCII-арт Дюка");
        char fSlash = '/';
        char bSlash = '\\';
        char underline = '_';
        char oParenthesis = '(';
        char clParenthesis = ')';

        System.out.println("    " + fSlash + bSlash);
        System.out.println("   " + fSlash + "  " + bSlash);
        System.out.println("  " + fSlash + underline + oParenthesis
                + " " + clParenthesis + bSlash);
        System.out.println(" " + fSlash + "      " + bSlash);
        System.out.println("" + fSlash + underline + underline + underline
                + underline + fSlash + bSlash + underline + underline + bSlash);

        System.out.println("\n8. Вывод количества сотен, десятков и единиц числа");
        int num3 = 123;
        int hundreds = num3 / 100;
        int tens = num3 / 10 % 10;
        int ones = num3 % 10;
        int sumDigits = hundreds + tens + ones;
        int multDigits = hundreds * tens * ones;

        System.out.println("Число " + num3 + " содержит:\n" + hundreds
                + " сотен\n" + tens + " десятков\n" + ones + " единиц");
        System.out.println("Сумма его цифр = " + sumDigits);
        System.out.println("Произведение = " + multDigits);

        System.out.println("\n9. Вывод времени");
        int totalSeconds = 86399;
        int hours = totalSeconds / 3600;
        int minutes = totalSeconds % 3600 / 60;
        int seconds = totalSeconds % 60;
        System.out.println(hours + ":" + minutes + ":" + seconds);
    }
}