package com.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


public class ExcerciseQueries {

    private static EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("PWLFT");

    private static Excercise excercise;
    private static TrainingSession trainingSession;


    public static void addExcercise(Excercise excercise) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();


            Excercise ex = new Excercise();
            //ex.setDate(excercise.getDate());
            //ex.setExcerciseString(excercise.getExcerciseString());
            //ex.setExcerciseString(recordToString(excercise.getExcerciseRecord()));
            em.persist(ex);
            et.commit();
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void addExcerciseAsList(Excercise excercise) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            Excercise ex = new Excercise();
            //ex.setDate(excercise.getDate());
            //ex.setExcerciseRecord(excercise.getExcerciseRecord());
            //ex.setExcerciseString(recordToString(excercise.getExcerciseRecord()));
            em.persist(ex);
            et.commit();
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void getTrainingSessions(LocalDate date1, LocalDate date2) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        List<TrainingSession> sessionQ;

        TypedQuery<TrainingSession> query = entityManager.createNamedQuery("findByDates", TrainingSession.class);
        query.setParameter("firstDate", date1);
        query.setParameter("secondDate", date2);
        sessionQ = query.getResultList();

        try {
            System.out.println(sessionQ.get(3).getExcerciseList().get(1).toString());

        } catch (NoResultException ex) {
            ex.printStackTrace();

        } finally {
            entityManager.close();
        }
    }


}
