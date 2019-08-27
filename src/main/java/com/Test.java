package com;

import com.Model.Excercise;
import com.Model.ExcerciseQueries;

import java.time.LocalDate;

public class Test {



    public static void main(String[] args) {

        ExcerciseQueries excerciseQueries = new ExcerciseQueries();

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

        excerciseQueries.getTrainingSessions(date, date2);


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
