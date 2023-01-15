public class MyFirstGame {

    public static void main(String[] args) {
        int secret = 77;

        for (int i = 2; i <= 100; i += 2) {
            if (i == secret) {
                System.out.println("Вы победили!");
                break;
            } else if (i < secret) {
                System.out.printf("Число %d меньше того, что загадал компьютер%n", i);
            } else {
                System.out.printf("Число %d больше того, что загадал компьютер%n", i);
            }

            if (i == 100) {
                i = 1;
            }
        }
    }
}