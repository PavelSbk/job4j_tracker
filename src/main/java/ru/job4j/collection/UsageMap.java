package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("psbk@gmail.com", "p sbk");
        map.put("xsbk@gmail.com", "x sbk");
        map.put("zsbk@gmail.com", "z sbk");
        for (String file : map.keySet()) {
            System.out.println(file + " : " + map.get(file));
        }
    }
}
