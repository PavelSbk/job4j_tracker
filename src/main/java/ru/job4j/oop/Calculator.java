package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
       return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        int y = 10;
        Calculator calc = new Calculator();
        System.out.println("Sum = " + sum(y));
        System.out.println("Difference = " + minus(y));
        System.out.println("Division = " + calc.divide(y));
        System.out.println("Multiplication = " + calc.multiply(y));
        System.out.println("Operations sum = " + calc.sumAllOperation(y));
    }
}
