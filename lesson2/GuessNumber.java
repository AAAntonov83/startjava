import java.lang.Math;
import java.util.Scanner;

public class GuessNumber {

    private Player player1;
    private Player player2;
    private int secretNumber;
    private int min = 1;
    private int max = 100;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        secretNumber = min + (int) (Math.random() * (max - min + 1));

        while (true) {
            inputNumber(player1);
            if (guessNumber(player1)) {
                break;
            }
            inputNumber(player2);
            if (guessNumber(player2)) {
                break;
            }
        }
    }

    private void inputNumber(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%s называет число: ", player.getName());

        while (true) {
            int answer = scanner.nextInt();
            if (answer >= min && answer <= max) {
                player.setNumber(answer);
                return;
            }
            System.out.printf("Введите число в диапазоне [%d, %d]: ", min, max);
        } 
    }

    private boolean guessNumber(Player player) {
        int number = player.getNumber();

        if (number == secretNumber) {
            System.out.printf("Игрок %s угадал число %d%n", player.getName(), secretNumber);
            return true;
        }
        if (number > secretNumber) {
            System.out.printf("Число %d больше того, что загадал компьютер.%n", number);
        } else {
            System.out.printf("Число %d меньше того, что загадал компьютер.%n", number);
        }
        return false;
    }
}