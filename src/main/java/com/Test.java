package com;

import com.Model.Excercise;
import com.Utils.ExcerciseQueries;
import com.Utils.ResultFilters;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.Utils.ExcerciseQueries.getPrimaryExcecises;
import static com.Utils.ResultFilters.filteredExcercises;

public class Test {

    public static List<Excercise> sessionQ;



    public static void main(String[] args) {

        ExcerciseQueries excerciseQueries = new ExcerciseQueries();
        ResultFilters filter = new ResultFilters();

        Excercise ex1 = new Excercise();



//        TrainingSet e1set1 = new TrainingSet(5,85); ex1.getSetsRecord().add(e1set1);
//        TrainingSet e1set2 = new TrainingSet(5,90); ex1.getSetsRecord().add(e1set2);
//        TrainingSet e1set3 = new TrainingSet(5,95); ex1.getSetsRecord().add(e1set3);
//        TrainingSet e1set4 = new TrainingSet(5,100); ex1.getSetsRecord().add(e1set4);
//
//        removeLast(ex1);
//        removeLast(ex1);
//        removeLast(ex1);
//        removeLast(ex1);
//        removeLast(ex1);

        LocalDate date = LocalDate.now().minusDays(1);
        LocalDate date2 = LocalDate.now();


        sessionQ = getPrimaryExcecises("prm");

        List<Excercise> filteredList = filteredExcercises(sessionQ, "Ben");

        //excerciseQueries.getTrainingSessions(date, date2);

        List<Excercise> downloadedExcercises = new ArrayList<>();
        for (Excercise e : sessionQ){
            System.out.println(e.getName() + "   " + e.getLiftMark());
            downloadedExcercises.add(e);
        }
        System.out.println("-----------------------------");
        for (Excercise e : filteredList){
            System.out.println(e.getName());
        }
        System.out.println("-----------------------------");
        System.out.println(filter.filteredExcercises(downloadedExcercises, "Bench"));


    }

    public static void removeLast(Excercise ex) {
        if (ex.getSetsRecord().isEmpty() == false) {
            ex.getSetsRecord().remove((ex.getSetsRecord().size() - 1));
            System.out.println(ex.getSetsRecord().toString());
        } else {
            System.out.println(ex.getSetsRecord().toString());
        }
    }
}
