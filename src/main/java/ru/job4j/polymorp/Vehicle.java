package ru.job4j.polymorp;

public interface Vehicle  extends Fuel {

    void accelerate();

    void brake();

    void steer();

    void changeGear();
}
