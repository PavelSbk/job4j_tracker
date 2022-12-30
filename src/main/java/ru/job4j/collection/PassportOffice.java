package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {

    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rst = !citizens.containsKey(citizen.getPassport());
        if (rst) {
            citizens.put(citizen.getPassport(), citizen);
        }
        return rst;
    }

    public Citizen get(String passport) {
        return citizens.get(passport);
    }
}
