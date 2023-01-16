class Wolf {

    private String name;
    private String gender;
    private int age;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 8) {
            System.out.println("Некорректный возраст.");
        }
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void move() {
        System.out.println("Иду куда-то.");
    }

    public void sit() {
        System.out.println("Сел отдохнуть.");
    }

    public void howl() {
        System.out.println("Вою на луну.");
    }

    public void hunt() {
        System.out.println("Охочусь на дичь.");
    }
}