package ru.job4j.oop;

public class Student {

    public void music() {
        System.out.println("Tra tra tra");
    }

    public void music(String lyrics) {
        System.out.println("I can sign a song : " + lyrics);
    }

    public static void main(String[] args) {
        Student petya = new Student();
        String song = "I believe, I can fly";
        for (int i = 0; i < 3; i++) {
            petya.music();
            petya.music(song);
        }
    }
}
