public class VariablesTheme {
    public static void main(String[] args) {
        System.out.println("1. Вывод значений переменных на консоль");

        System.out.println("2. Расчет стоимости товара со скидкой");
        //int penPrice = 100;
        //int bookPrice = 200;
        //int discount = 11;

        System.out.println("");

        System.out.println("3. Вывод слова JAVA");

        System.out.println("4. Вывод min и max значений целых числовых типов");

        System.out.println("5. Перестановка значений переменных");

        System.out.println("6. Вывод символов и их кодов");

        System.out.println("7. Вывод в консоль ASCII-арт Дюка");

        System.out.println("8. Вывод количества сотен, десятков и единиц числа");
        int num = 123;
        int hundreds = num / 100;
        int tens = num % 100 / 10;
        int units = num % 100 % 10;
        int sum = hundreds + tens + units;
        int mul = hundreds * tens * units;

        System.out.println("Число " + num + " содержит:\n" + hundreds
                + " сотен\n" + tens + " десятков\n" + units + " единиц");
        System.out.println("Сумма его цифр = " + sum);
        System.out.println("Произведение = " + mul);

        System.out.println("\n9. Вывод времени");
        int seconds = 86399;
        int hours = seconds / 3600;
        int minutes = 86399 % 3600 / 60;
        seconds = seconds % 3600 % 60;
        System.out.println(hours + ":" + minutes + ":" + seconds);
    }
}