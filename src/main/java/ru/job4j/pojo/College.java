package ru.job4j.pojo;

import java.util.Date;

public class College {

    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("Ivan Ivanovich Ivanov");
        student1.setGroup(1013);
        student1.setDate(new Date());
        System.out.println("Name  : " + student1.getName() + System.lineSeparator()
                + "Group : " + student1.getGroup() + System.lineSeparator()
                + "Date  : " + student1.getDate());
    }
}
