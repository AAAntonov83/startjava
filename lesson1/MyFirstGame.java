public class MyFirstGame {

    public static void main(String[] args) {
        int secretNumber = 77;

        for (int i = 2; i <= 100; i += 2) {
            if (i == secretNumber) {
                System.out.println("Вы победили!");
                break;
            }

            if (i < secretNumber) {
                System.out.printf("Число %d меньше того, что загадал компьютер%n", i);
            } else {
                System.out.printf("Число %d больше того, что загадал компьютер%n", i);
            }

            if (i == 100) {
                i = -1;
            }
        }
    }
}