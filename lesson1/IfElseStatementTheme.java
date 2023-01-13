public class IfElseStatementTheme {

    public static void main(String[] args) {
        System.out.println("1. Перевод псевдокода на язык Java");
        int age = 20;
        if (age > 20) {
            System.out.println("You are over 20 years old");
        } else {
            System.out.println("You are under 21 years old");
        }

        boolean isMale = true;
        if (isMale) {
            System.out.println("You are a man");
        } else {
            System.out.println("You are not a man");
        }

        float height = 1.81f;
        if (height < 1.80) {
            System.out.println("Cool!");
        } else {
            System.out.println("Play basketball?");
        }

        char firstLetterName = "Sylvester".charAt(0);
        if (firstLetterName == 'S') {
            System.out.println("Hello, Sylvester!");
        } else if (firstLetterName == 'A') {
            System.out.println("Hello, Arnold!");
        } else {
            System.out.println("Sorry, i don't know your name.");
        }

        System.out.println("\n2. Поиск max и min числа");
        int num1 = 5;
        int num2 = 10;
        if (num1 < num2) {
            System.out.println("Число " + num1 + " - минимальное, число "
                    + num2 + " - максимальное.");
        } else if (num1 == num2) {
            System.out.println("Числа равны.");
        } else {
            System.out.println("Число " + num1 + " - максимальное, число "
                    + num2 + " - минимальное.");
        }

        System.out.println("\n3. Проверка числа");
        int num3 = 11;
        if (num3 > 0) {
            if (num3 % 2 == 0) {
                System.out.println("Число " + num3 + " четное");
            } else {
                System.out.println("Число " + num3 + " нечетное");
            }
        } else {
            System.out.println("Число " + num3 + " это ноль.");
        }

        System.out.println("\n4. Поиск одинаковых цифр в числах");
        int num4 = 246;
        int num5 = 147;
        boolean isNumberMatched = false;
        System.out.println("Исходные числа: " + num4 + " и " + num5);

        if (num4 / 100 == num5 / 100) {
            System.out.println("Совпадение в третьем разряде - " + num4 / 100);
            isNumberMatched = true;
        }
        if (num4 / 10 % 10 == num5 / 10 % 10) {
            System.out.println("Совпадение во втором разряде - " + num4 / 10 % 10);
            isNumberMatched = true;
        }
        if (num4 % 10 == num5 % 10) {
            System.out.println("Совпадение в первом разряде - " + num4 % 10);
            isNumberMatched = true;
        }
        if (!isNumberMatched) {
            System.out.println("Совпадения чисел в разрядах отсутствуют.");
        }

        System.out.println("\n5. Определение символа по его коду");
        char sym = '\u0057';

        if (sym >= 'a' && sym <= 'z') {
            System.out.println(sym + " - маленькая буква.");
        } else if (sym >= 'A' && sym <= 'Z') {
            System.out.println(sym + " - заглавная буква.");
        } else if (sym >= '0' && sym <= '9') {
            System.out.println(sym + " - число.");
        } else {
            System.out.println(sym + " - не буква и не число.");
        }

        System.out.println("\n6. Подсчет суммы вклада и начисленных банком %");
        float depositAmount = 300_000f;
        float interestAmount = 0f;

        if (depositAmount < 100_000) {
            interestAmount = depositAmount * 0.05f;
        } else if (depositAmount <= 300_000) {
            interestAmount = depositAmount * 0.07f;
        } else {
            interestAmount = depositAmount * 0.1f;
        }
        System.out.println("Сумма вклада: " + depositAmount + ", начисленный процент: "
                + interestAmount + ", итоговая сумма: " + (depositAmount + interestAmount));

        System.out.println("\n7. Определение оценки по предметам");
        byte historyPercent = 59;
        int historyGrade = 2;
        byte programmingPercent = 91;
        int programmingGrade = 2;

        if (historyPercent > 91) {
            historyGrade = 5;
        } else if (historyPercent > 73) {
            historyGrade = 4;
        } else if (historyPercent > 60) {
            historyGrade = 3;
        }

        if (programmingPercent > 91) {
            programmingGrade = 5;
        } else if (programmingPercent > 73) {
            programmingGrade = 4;
        } else if (programmingPercent > 60) {
            programmingGrade = 3;
        }

        System.out.println(historyGrade + " история");
        System.out.println(programmingGrade + " программирование");
        System.out.println("Средний балл " + ((float) historyGrade + programmingGrade) / 2);
        System.out.println("Средний процент " + ((float) historyPercent + programmingPercent) / 2);

        System.out.println("\n8. Расчет прибыли за год");
        int rent = 5000;
        int cost = 9000;
        int revenue = 13000;
        int profit = (revenue - (rent + cost)) * 12;
        String sigh = "";

        if (profit > 0) {
            sigh = "+";
        }
        System.out.println("Прибыль за год: " + sigh + profit);

        System.out.println("\n9. Подсчет количества банкнот");
        int withdrawAmount = 567;
        int hundreds = withdrawAmount / 100;
        int tens = withdrawAmount / 10 % 10;
        int ones = withdrawAmount % 10;
        int hundredsAtm = 10;
        int tensAtm = 5;
        int onesAtm = 50;

        if (hundreds > hundredsAtm) {
            tens += (hundreds - hundredsAtm) * 10;
            hundreds = hundredsAtm;
        }
        if (tens > tensAtm) {
            ones += (tens - tensAtm) * 10;
            tens = tensAtm;
        }
        if (ones > onesAtm) {
            System.out.println("Купюр в банкомате недостаточно.");
        } else {
            System.out.println("Купюр 100$ - " + hundreds + " шт., купюр 10$ - " + tens +
                " шт., купюр 1$ - " + ones + " шт.\nВсего " + withdrawAmount + "$ к выдаче");
        }
    }
}