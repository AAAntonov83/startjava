import java.util.Scanner;

public class GuessNumberTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя первого участника: ");
        String name = scanner.nextLine();
        Player player1 = new Player(name);
        
        System.out.print("Введите имя второго участника: ");
        name = scanner.next();
        Player player2 = new Player(name);

        String answer = "yes";
        GuessNumber game = new GuessNumber(player1, player2);

        while (!answer.equals("no")) {
            game.start();

            do {
                System.out.println("Хотите продолжить игру? [yes/no]");
                answer = scanner.next();
            } while (!answer.equals("yes") & !answer.equals("no"));
        }
    }
}