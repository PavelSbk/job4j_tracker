package oop;

public class DummyDic {

    public String engToRus(String eng) {
        return "Неизвестное слово. " + eng;
    }

    public static void main(String[] args) {
        DummyDic dD = new DummyDic();
        System.out.println(dD.engToRus("Hello"));
    }
}
