package com.startjava.lesson_2_3_4.robot;

public class Jaeger {

    private String modelName;
    private String weaponName;
    private int strength;

    public Jaeger() {
        this("undefined model", "undefined weapon");
    }

    public Jaeger(String modelName, String weaponName) {
        this.modelName = modelName;
        this.weaponName = weaponName;
    }

    public Jaeger(String modelName, String weaponName, int strength) {
        this(modelName, weaponName);
        this.strength = strength;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void move() {
        System.out.printf("\"%s\" двигается к цели%n", modelName);
    }

    public boolean detectTarget() {
        System.out.printf("\"%s\" обнаружил цель%n", modelName);
        return true;
    }

    public void useWeapon() {
        if (strength == 0) {
            System.out.printf("Орудие \"%s\" пришло в неисправность.%n",
                    weaponName);
        } else {
            System.out.printf("\"%s\" применил \"%s\" по цели и нанес %d единиц урона%n",
                    modelName, weaponName, strength);
        }
    }
}