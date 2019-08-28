package com.Utils;

import com.Model.Excercise;
import com.Model.TrainingSession;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


public class ExcerciseQueries {

    private static EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("PWLFT");

    public static void getTrainingSessions(LocalDate date1, LocalDate date2) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        List<TrainingSession> sessionQ;

        TypedQuery<TrainingSession> query = entityManager.createNamedQuery("findByDates", TrainingSession.class);
        query.setParameter("firstDate", date1);
        query.setParameter("secondDate", date2);
        sessionQ = query.getResultList();
        try {
            //todo remove/replace printing after tests
            System.out.println(sessionQ.get(3).getExcerciseList().get(1).toString());
        } catch (NoResultException ex) {
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public static List<Excercise> getPrimaryExcecises(String mark) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        List<Excercise> sessionQ;
        TypedQuery<Excercise> query = entityManager.createNamedQuery("primaryExcercises", Excercise.class);
        query.setParameter("liftMark", mark);
        sessionQ = query.getResultList();
        try {
            return sessionQ;
        } catch (NoResultException ex) {
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
        return sessionQ;
    }




    public static void getSingleSession(LocalDate date) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        TrainingSession sessionQ;

        TypedQuery<TrainingSession> query = entityManager.createNamedQuery("singleSession", TrainingSession.class);
        query.setParameter("singleDate", date);
        sessionQ = query.getSingleResult();
        try {
            //todo remove/replace printing after tests
            System.out.println(sessionQ.getExcerciseList().get(0).toString());
        } catch (NoResultException ex) {
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
    }


    //todo add removal and amending queries/methods


}