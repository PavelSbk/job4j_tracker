package ru.job4j.tracker;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class UsagePackageDate {

    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Текущая дата: " + currentDate);
        System.out.println("Текущее время: " + currentTime);
        System.out.println("Текущие дата и время: " + currentDateTime.format(formatter));
    }
}
