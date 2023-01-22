package com.startjava.lesson_2_3.animal;

public class WolfTest {

    public static void main(String[] args) {
        Wolf wolfOne = new Wolf();
        wolfOne.setName("Wolfy");
        wolfOne.setGender("male");
        wolfOne.setColor("black");
        wolfOne.setAge(9);

        System.out.printf("Name: %s, gender: %s, age: %d, color: %s%n",
                wolfOne.getName(), wolfOne.getGender(), wolfOne.getAge(), wolfOne.getColor());
        wolfOne.move();
        wolfOne.sit();
        wolfOne.howl();
        wolfOne.hunt();
    }
}