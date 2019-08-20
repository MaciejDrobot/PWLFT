package com;


import com.Model.Excercise;
import com.Model.TrainingSession;
import com.Model.TrainingSet;

import javax.persistence.*;
import java.util.List;

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

        TrainingSet e1set1 = new TrainingSet(5,85); ex1.getSetsRecord().add(e1set1);
        TrainingSet e1set2 = new TrainingSet(5,100); ex1.getSetsRecord().add(e1set2);
        TrainingSet e1set3 = new TrainingSet(5,85); ex1.getSetsRecord().add(e1set3);
        TrainingSet e1set4 = new TrainingSet(5,85); ex1.getSetsRecord().add(e1set4);

        ex1.setOneRM(ex1.calculateOneRM(ex1.getSetsRecord()));
        ex1.setVolume(ex1.calculateVolume(ex1.getSetsRecord()));
        ex1.setTotalReps(ex1.calculateTotalReps(ex1.getSetsRecord()));
        ex1.setIntensity(ex1.calculateIntensityShort(ex1.getVolume(), ex1.getTotalReps()));
        ex1.setTopSet(ex1.getTopSet(ex1.getSetsRecord()));
        ex1.setSetsRecordAsString(ex1.recordToStringToPrint(ex1.getSetsRecord()));


        ex2.setName("Squat");
        ex2.setLiftMark("Secondary");
        TrainingSet e2set1 = new TrainingSet(10,100); ex2.getSetsRecord().add(e2set1);
        TrainingSet e2set2 = new TrainingSet(10,100); ex2.getSetsRecord().add(e2set2);
        TrainingSet e2set3 = new TrainingSet(10,100); ex2.getSetsRecord().add(e2set3);
        TrainingSet e2set4 = new TrainingSet(10,100); ex2.getSetsRecord().add(e2set4);
        ex2.setSetsRecordAsString(ex2.recordToStringToPrint(ex2.getSetsRecord()));




        session.setDate("23.08.2019");
        session.getExcerciseList().add(ex1);
        session.getExcerciseList().add(ex2);
        ex1.setTrainingSession(session);
        ex2.setTrainingSession(session);


        entityManager.persist(ex1);
        entityManager.persist(ex2);
        entityManager.persist(session);

        //printTrainingSession(session);

        TypedQuery<TrainingSession> query = entityManager.createNamedQuery("findByDate",TrainingSession.class);
        query.setParameter("name_param", "22.08.2019");
        TrainingSession sessionQ = query.getSingleResult();


        printTrainingSession(sessionQ);



        tx.commit();
        entityManager.close();
        entityManagerFactory.close();

        System.exit(0);


    }

    public static void printTrainingSession(TrainingSession session){
        List<Excercise> listOfExcecises = session.getExcerciseList();
        for (Excercise e : listOfExcecises) {
            if(e.getLiftMark() == "Primary"){
                System.out.println("Main lift: " + e.getName() + "  " + e.getRepetitionMark());
            } else {
                System.out.println("Secondary: " + e.getName());
            }
            System.out.println("Sets: " + e.getSetsRecordAsString());
            System.out.println("--------------------------------");

        }

    }

}
