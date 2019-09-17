package com.Utils;

import com.Model.Exercise;
import com.Model.TrainingSession;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Filters {

    public static List<Exercise> getExerciseByName(List<Exercise> list, String name){
        return list.stream()
                .filter(e -> e.getName().contains(name))
                .collect(Collectors.toList());
    }

    public static TrainingSession getSessionByDate(List<TrainingSession> list, LocalDate date){
        List<TrainingSession> filtered = list.stream()
                .filter(s -> s.getDate().equals(date))
                .collect(Collectors.toList());
        return filtered.get(0);
    }

    public static List<TrainingSession> getSessionsBetweenDates(List<TrainingSession> list, LocalDate start, LocalDate end) {
        return list.stream()
                .filter(s -> s.getDate().isAfter(start.minusDays(1))
                        && s.getDate().isBefore(end.plusDays(1)))
                .collect(Collectors.toList());
    }

    public static List<Exercise> getExercisesBetweenDates(List<Exercise> list, LocalDate start, LocalDate end){
        return list.stream()
                .filter(e -> e.getDate().isAfter(start.minusDays(1))
                        && e.getDate().isBefore(end.plusDays(1)))
                .collect(Collectors.toList());
    }

    public static List<Exercise> sortExercisesByDate(List<Exercise> list) {
        return list.stream()
                .sorted(Comparator.comparing(Exercise::getDate))
                .collect(Collectors.toList());
    }

    public static List<Exercise> filterRepsMark(List<Exercise> list, String x3, String x5) {
        return list.stream()
                .filter(e -> e.getRepetitionMark().contains(x3) || e.getRepetitionMark().contains(x5))
                .collect(Collectors.toList());
    }

    //TODO refactor filters
}