package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void ride() {
        System.out.println("The bus rides");
    }

    @Override
    public void passengers(int count) {
        System.out.println("There are " + count + "passengers inside.");
    }

    @Override
    public double refuel(int fuel) {
        return fuel * 51.5;
    }
}
