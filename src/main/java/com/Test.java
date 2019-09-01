package com;

import com.Model.Excercise;
import com.Utils.ExcerciseQueries;
import com.Utils.ResultFilters;

import java.time.LocalDate;
import java.util.List;

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

        LocalDate date = LocalDate.now().minusDays(35);
        LocalDate date2 = LocalDate.now();


        sessionQ = excerciseQueries.getPrimaryExcercisesBetweenDates(date, date2);


        //List<Excercise> filteredList = sessionQ.filteredExcercises(sessionQ, "Ben");

        //excerciseQueries.getTrainingSessions(date, date2);

//        List<Excercise> downloadedExcercises = new ArrayList<>();
//        System.out.println("All primary between dates: ");
//        for (Excercise e : sessionQ){
//            System.out.println(e.getName() + "   " + e.getLiftMark());
//            downloadedExcercises.add(e);
//        }
//        System.out.println("-----------------------------");
//        System.out.println("Only filtered: ");
////        for (Excercise e : filteredList){
////            System.out.println(e.getName());
////        }
//        System.out.println("-----------------------------");
//        System.out.println(filter.filteredExcercises(downloadedExcercises, "Bench"));
//
//
//    }
//
//    public static void removeLast(Excercise ex) {
//        if (ex.getSetsRecord().isEmpty() == false) {
//            ex.getSetsRecord().remove((ex.getSetsRecord().size() - 1));
//            System.out.println(ex.getSetsRecord().toString());
//        } else {
//            System.out.println(ex.getSetsRecord().toString());
//        }
//    }

        System.out.println(downloadData("Bench", date, date2).toString());





    }

    public static List<Excercise> downloadData (String excercise, LocalDate date1, LocalDate date2){
        ExcerciseQueries eq = new ExcerciseQueries();
        List<Excercise> betweenDates = eq.getPrimaryExcercisesBetweenDates(date1, date2);
        return eq.filteredExcercises(betweenDates, excercise);
    }
}
