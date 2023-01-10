public class Intro{
    public static void main(String[] args) {
        System.out.println("Enter your name.");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Welcome to the JDK, " + name + "!");
    }
}