public class VariablesTheme {

    public static void main(String[] args) {
        System.out.println("1. Вывод значений переменных на консоль");
        byte processorCount = 16;
        short streamCount = 24;
        int cpuModel= 12900;
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
        int discount = 11;
        float sum = (float) (100 - discount) / 100 * (penPrice + bookPrice);
        System.out.println("Сумма скидки - " + discount + "%");
        System.out.println("Сумма товаров со скидкой - " + sum);

        System.out.println("\n3. Вывод слова JAVA");
        System.out.println("   J    a  V     V  a");
        System.out.println("   J   a a  V   V  a a");
        System.out.println("J  J  aaaaa  V V  aaaaa");
        System.out.println(" JJ  a     a  V  a     a");

        System.out.println("\n4. Вывод min и max значений целых числовых типов");
        byte num = 127;
        System.out.println(num);
        num++;
        System.out.println(num);
        num--;
        System.out.println(num);

        short num1 = 32_767;
        System.out.println(num1);
        num1++;
        System.out.println(num1);
        num1--;
        System.out.println(num1);

        int num2 = 2_147_483_647;
        System.out.println(num2);
        num2++;
        System.out.println(num2);
        num2--;
        System.out.println(num2);

        long num3 = 9_223_372_036_854_775_807L;
        System.out.println(num3);
        num3++;
        System.out.println(num3);
        num3--;
        System.out.println(num3);

        System.out.println("\n5. Перестановка значений переменных");
        System.out.println("Перестановка через третью переменную.");
        int num4 = 2;
        int num5 = 5;
        System.out.println(num4 + " " + num5);
        int num6 = num5;
        num5 = num4;
        num4 = num6;
        System.out.println(num4 + " " + num5);

        System.out.println("Перестановка через арифметическую операцию.");
        System.out.println(num4 + " " + num5);
        num4 += num5;
        num5 = num4 - num5;
        num4 -= num5;
        System.out.println(num4 + " " + num5);

        System.out.println("Перестановка через побитовую операцию.");
        System.out.println(num4 + " " + num5);
        num4 ^= num5;
        num5 ^= num4;
        num4 ^= num5;
        System.out.println(num4 + " " + num5);

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
        char leftSide = '/';
        char rightSide = '\\';
        char bottom = '_';
        char leftNose = '(';
        char rightNose = ')';
        char space = ' ';

        System.out.println("" + space + space + space + space + leftSide + rightSide);
        System.out.println("" + space + space + space + leftSide + space + space + rightSide);
        System.out.println("" + space + space + leftSide + bottom + leftNose + space + rightNose + rightSide);
        System.out.println("" + space + leftSide + space + space + space + space + space + space + rightSide);
        System.out.println("" + leftSide + bottom + bottom + bottom + bottom + leftSide + rightSide + bottom + bottom + rightSide);

        System.out.println("\n8. Вывод количества сотен, десятков и единиц числа");
        int num7 = 123;
        int hundreds = num7 / 100;
        int tens = num7 % 100 / 10;
        int units = num7 % 100 % 10;
        int sum1 = hundreds + tens + units;
        int mul = hundreds * tens * units;

        System.out.println("Число " + num7 + " содержит:\n" + hundreds
                + " сотен\n" + tens + " десятков\n" + units + " единиц");
        System.out.println("Сумма его цифр = " + sum1);
        System.out.println("Произведение = " + mul);

        System.out.println("\n9. Вывод времени");
        int seconds = 86399;
        int hours = seconds / 3600;
        int minutes = 86399 % 3600 / 60;
        seconds = seconds % 3600 % 60;
        System.out.println(hours + ":" + minutes + ":" + seconds);
    }
}