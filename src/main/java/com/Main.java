package com;

import com.Model.TrainingSession;
import com.Utils.AllSessions;
import com.Utils.Queries;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        Queries eq = new Queries();
        List<TrainingSession> list = AllSessions.getInstance().getAllSessions();

        LocalDate startDate = LocalDate.now().minusDays(6);
        LocalDate endDate = LocalDate.now().minusDays(4);


        //Date.valueOf(date).toLocalDate();

        //System.out.println(AllSessions.getInstance().getAllSessions().get(0).getDate());

        //TrainingSession session = Filters.getSessionByDate(AllSessions.getInstance().getAllSessions(), date);
        //System.out.println(list.toString());

        System.out.println(startDate.toString());
        System.out.println(endDate.toString());

        for (TrainingSession s : getSessionsBetweenDates(list, startDate, endDate)){
            System.out.println(s.getDate().toString() + " " + s.getSessionId());
        }






    }

    public static List<TrainingSession> getSessionsBetweenDates(List<TrainingSession> list, LocalDate start, LocalDate end) {
        List<TrainingSession> filtered = new ArrayList<>();
        for (TrainingSession s : list){
            if (s.getDate().isBefore(end.plusDays(1)) && s.getDate().isAfter(start.minusDays(1))){
                filtered.add(s);
            }
        }
        return filtered;
    }
}
