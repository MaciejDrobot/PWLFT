package com;

import com.Model.TrainingSession;
import com.Utils.AllSessions;
import com.Utils.Queries;
import com.Utils.Filters;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        Queries eq = new Queries();
        List<TrainingSession> list = new ArrayList<>();

        LocalDate date = LocalDate.now().minusDays(2);
        System.out.println(date);

        Date.valueOf(date).toLocalDate();

        System.out.println(AllSessions.getInstance().getAllSessions().get(0).getDate());

        TrainingSession session = Filters.getSessionByDate(AllSessions.getInstance().getAllSessions(), date);

        System.out.println(session.toString());

//        for (int i = 0; i < eq.getAllSessions().size() - 1; i++){
//            list.add(eq.getAllSessions().get(i));
//            System.out.println(list.get(i));
//            System.out.println("------------------------");
//        }

//        list  = AllSessions.getInstance().getAllSessions();
//
//
//        TrainingSession session = list.get(1);
//
//        System.out.println(session.toString());



    }
}
