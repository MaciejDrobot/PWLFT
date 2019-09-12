package com.Utils;

import com.Model.Exercise;
import com.Model.TrainingSession;

import java.time.LocalDate;
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

    public static List<Exercise> getExercisesBetweenDates(List<Exercise> list, LocalDate date1, LocalDate date2){
        List<Exercise> filtered = list;

        return filtered;
    }


}