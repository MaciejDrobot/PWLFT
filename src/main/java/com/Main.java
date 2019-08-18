package com;


import com.Model.Excercise;
import com.Model.TrainingSession;
import com.Model.TrainingSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    static TrainingSession session = new TrainingSession();
    static Excercise ex1 = new Excercise();
    static Excercise ex2 = new Excercise();
    static Excercise ex3 = new Excercise();
    static Excercise ex4 = new Excercise();
    static Excercise ex5 = new Excercise();

    public static void main( String[] args ) {

        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("PWLFT");

        EntityManager entityManager
                = entityManagerFactory.createEntityManager();

        System.out.println("Is ok: " + entityManager.isOpen());

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        ex1.setName("Bench");
        ex1.setLiftMark("Primary");
        ex1.setRepetitionMark("x 5");

        TrainingSet set1 = new TrainingSet(5,85); ex1.getSetsRecord().add(set1);
        TrainingSet set2 = new TrainingSet(5,90); ex1.getSetsRecord().add(set2);
        TrainingSet set3 = new TrainingSet(5,85); ex1.getSetsRecord().add(set3);

        ex1.setOneRM(ex1.calculateOneRM(ex1.getSetsRecord()));
        ex1.setVolume(ex1.calculateVolume(ex1.getSetsRecord()));
        ex1.setTotalReps(ex1.calculateTotalReps(ex1.getSetsRecord()));
        ex1.setIntensity(ex1.calculateIntensityShort(ex1.getVolume(), ex1.getTotalReps()));
        ex1.setTopSet(ex1.getTopSet());
        ex1.setSetsRecordAsString(ex1.recordToStringToPrint(ex1.getSetsRecord()));

        session = new TrainingSession("18/08/2019", ex1);

        entityManager.persist(session);
        //entityManager.persist(ex1);
        tx.commit();

        entityManager.close();
        entityManagerFactory.close();

        System.exit(0);


    }

}
