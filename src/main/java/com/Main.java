package com;

import com.Model.Exercise;
import com.Model.TrainingSession;
import com.Utils.AllSessions;
import com.Utils.Queries;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
        Queries eq = new Queries();
        List<TrainingSession> list = AllSessions.getInstance().getAllSessions();

        LocalDate startDate = LocalDate.now().minusDays(7);
        LocalDate endDate = LocalDate.now().minusDays(4);


        //Date.valueOf(date).toLocalDate();

        //System.out.println(AllSessions.getInstance().getAllSessions().get(0).getDate());

        //TrainingSession session = Filters.getSessionByDate(AllSessions.getInstance().getAllSessions(), date);
        //System.out.println(list.toString());

        System.out.println(startDate.toString());
        System.out.println(endDate.toString());
        System.out.println();

        for (TrainingSession s : getSessionsBetweenDates(list, startDate, endDate)) {
            System.out.println(s.getDate().toString() + " " + s.getSessionId());
        }

        System.out.println();

//        for (TrainingSession s : sortByDate(getSessionsBetweenDates(list, startDate, endDate))) {
//            System.out.println(s.getDate().toString() + " " + s.getSessionId());
//        }


    }

    public static List<Exercise> filterRepsMark(List<Exercise> list, String x3, String x5) {
        return list.stream()
                .filter(e -> e.getRepetitionMark().contains(x3) || e.getRepetitionMark().contains(x5))
                .collect(Collectors.toList());
    }

    public static List<TrainingSession> getSessionsBetweenDates(List<TrainingSession> list, LocalDate start, LocalDate end) {
        return list.stream()
                .filter(s -> s.getDate().isAfter(start.minusDays(1))
                        && s.getDate().isBefore(end.plusDays(1)))
                .collect(Collectors.toList());
    }
}

