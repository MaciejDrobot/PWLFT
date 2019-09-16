package com.Utils;

import com.Model.Exercise;
import com.Model.TrainingSession;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filters {

    public static List<Exercise> getExerciseByName(List<Exercise> list, String name){
        List<Exercise> filtered = list.stream()
                .filter(e -> e.getName().contains(name))
                .collect(Collectors.toList());
        return filtered;
    }

    public static TrainingSession getSessionByDate(List<TrainingSession> list, LocalDate date){
        List<TrainingSession> filtered = list.stream()
                .filter(s -> s.getDate().equals(date))
                .collect(Collectors.toList());
        return filtered.get(0);
    }

    public static List<TrainingSession> getSessionsBetweenDates(List<TrainingSession> list, LocalDate start, LocalDate end) {
        List<TrainingSession> filtered = new ArrayList<>();
        for (TrainingSession s : list){
            if (s.getDate().isBefore(end.plusDays(1)) && s.getDate().isAfter(start.minusDays(1))){
                filtered.add(s);
            }
        } return filtered;
    }

    public static List<Exercise> getExercisesBetweenDates(List<Exercise> list, LocalDate start, LocalDate end){
        List<Exercise> filtered = new ArrayList<>();
        for (Exercise e : list){
            if (e.getDate().isBefore(end.plusDays(1)) && e.getDate().isAfter(start.minusDays(1))){
                filtered.add(e);
            }
        } return filtered;
    }
}