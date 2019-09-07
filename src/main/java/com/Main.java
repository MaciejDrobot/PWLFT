package com;

import com.Model.TrainingSession;
import com.Utils.AllData;
import com.Utils.ExerciseQueries;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        ExerciseQueries eq = new ExerciseQueries();
        List<TrainingSession> list = new ArrayList<>();

        LocalDate date = LocalDate.now().minusDays(2);
        System.out.println(date);

        Date.valueOf(date).toLocalDate();

        System.out.println(AllData.getInstance().getAllData().get(0).getDate());

        TrainingSession session = ExerciseQueries.getSession(AllData.getInstance().getAllData(), date);

        System.out.println(session.toString());

//        for (int i = 0; i < eq.getAllData().size() - 1; i++){
//            list.add(eq.getAllData().get(i));
//            System.out.println(list.get(i));
//            System.out.println("------------------------");
//        }

//        list  = AllData.getInstance().getAllData();
//
//
//        TrainingSession session = list.get(1);
//
//        System.out.println(session.toString());



    }
}
