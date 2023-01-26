package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {

    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> predName = s -> s.getName().contains(key);
        Predicate<Person> predSurname = s -> s.getSurname().contains(key);
        Predicate<Person> predAdress = s -> s.getAddress().contains(key);
        Predicate<Person> predPhone = s -> s.getPhone().contains(key);
        Predicate<Person> combine = predSurname.or(predPhone).or(predAdress).or(predName);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
