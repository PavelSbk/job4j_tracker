package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {

    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getPhone().contains(key)
                    || person.getSurname().contains(key)
                    || person.getAddress().contains(key)
                    || person.getName().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
}
