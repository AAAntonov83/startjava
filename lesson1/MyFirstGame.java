public class MyFirstGame {

    public static void main(String[] args) {
        int secretNumber = 77;
        int playerNumber = 88;

        while (true) {
            if (playerNumber == secretNumber) {
                System.out.println("Вы победили!");
                break;
            }

            if (playerNumber < secretNumber) {
                System.out.printf("Число %d меньше того, что загадал компьютер%n", playerNumber);
                playerNumber++;
            } else {
                System.out.printf("Число %d больше того, что загадал компьютер%n", playerNumber);
                playerNumber--;
            }
        }
    }
}