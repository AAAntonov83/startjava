public class JaegerTest {

    public static void main(String[] args) {
        Jaeger jaeger1 = new Jaeger();
        jaeger1.setModelName("Gipsy Danger");
        jaeger1.setWeaponName("I-19 Plasmacaster");
        jaeger1.setStrength(8);

        System.out.printf("%s патрулирует%n", jaeger1.getModelName()); 
        if (jaeger1.detectTarget()) {
            jaeger1.move();
            jaeger1.useWeapon();
            jaeger1.setStrength(0);
            jaeger1.useWeapon();
        }
        
        Jaeger jaeger2 = new Jaeger("Striker Eureka", "WMB2x90 AKM Chest launcher", 10);
        System.out.printf("%s вышел из ангара в подкрепление%n", jaeger2.getModelName());
        if (jaeger2.detectTarget()) {
            jaeger2.move();
            jaeger2.useWeapon();
            jaeger2.move();
            jaeger2.setWeaponName("Assault Mount 3.25 \"Sting-Blades\"");
            jaeger2.setStrength(15);
            jaeger2.useWeapon();
        }
    }
}