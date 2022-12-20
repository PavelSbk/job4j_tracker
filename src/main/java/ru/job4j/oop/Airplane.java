package ru.job4j.oop;

public class Airplane implements Vehicle {

    private static final int SPEED = 890;

    @Override
    public void speed() {
        System.out.printf("Cкорость %s, в среднем, %d км/ч %s",
                getClass().getSimpleName(), SPEED, System.lineSeparator());
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летает");
    }
}
