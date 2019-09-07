package com;

import com.Model.TrainingSession;
import com.Utils.ExerciseQueries;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        ExerciseQueries eq = new ExerciseQueries();
        List<TrainingSession> list = new ArrayList<>();

        LocalDate date = LocalDate.now();

        for (int i = 0; i < eq.getAllData().size() - 1; i++){
            list.add(eq.getAllData().get(i));
            System.out.println(list.get(i));
            System.out.println("------------------------");
        }

        //list  = eq.getAllData();


        TrainingSession session = list.get(0);

        System.out.println(session.toString());



    }
}
