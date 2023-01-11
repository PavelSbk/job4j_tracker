package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String dep1, String dep2) {
        String[] splitDep1 = dep1.split("/");
        String[] splitDep2 = dep2.split("/");
        int rst = splitDep2[0].compareTo(splitDep1[0]);
        return rst != 0 ? rst : dep1.compareTo(dep2);
    }
}
