package ru.job4j.inheritance;

public class Child extends Parent {

    private String patronymic;

    public Child(String name, int age, String patronymic) {
        super(name, age);
        this.patronymic = patronymic;
    }

    public static void main(String[] args) {
        Child ch1 = new Child("Buba", 55, "Bub's");
        System.out.println(ch1.patronymic);
    }
}
