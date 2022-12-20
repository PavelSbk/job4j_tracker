package ru.job4j.oop;

public class VehicleUsage {

    public static void main(String[] args) {
        Airplane plane = new Airplane();
        Train train = new Train();
        Bus bus = new Bus();
        Vehicle[] vehicles = {plane, train, bus};
        for (Vehicle v : vehicles) {
            v.move();
            v.speed();
        }
    }
}
