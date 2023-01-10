package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        int counter = 0;
        double scoreSum = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scoreSum += subject.score();
                counter++;
            }
        }
        return scoreSum / counter;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rst = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sumScore = 0;
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
            }
            rst.add(new Label(pupil.name(), sumScore / pupil.subjects().size()));
        }
        return rst;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> rst = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int scoreSum = subject.score();
                if (map.containsKey(subject.name())) {
                    scoreSum = map.get(subject.name()) + subject.score();
                }
                map.put(subject.name(), scoreSum);
            }
        }
        for (String name : map.keySet()) {
            rst.add(new Label(name, map.get(name) / (double) pupils.size()));
        }
        return rst;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> rst = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sumScore = 0;
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
            }
            rst.add(new Label(pupil.name(), sumScore));
        }
        rst.sort(Comparator.naturalOrder());
        return rst.get(rst.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> rst = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int scoreSum = map.getOrDefault(subject.name(), 0) + subject.score();
                map.put(subject.name(), scoreSum);
            }
        }
        for (String name : map.keySet()) {
            rst.add(new Label(name, map.get(name)));
        }
        rst.sort(Comparator.naturalOrder());
        return rst.get(rst.size() - 1);
    }
}
