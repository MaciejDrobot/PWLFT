package com.Model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class ExcerciseQueries {

    private static EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("Excercise");

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

//    public static void getExcercise(int id) {
//        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
//
//        String query = "SELECT excercise FROM training WHERE excercise.id = :excerciseID";
//
//        TypedQuery<TrainingSet> tq = em.createQuery(query, TrainingSet.class);
//        tq.setParameter("excerciseID", id);
//        TrainingSet trainingSet = null;
//        try {
//            trainingSet = tq.getSingleResult();
//
//            System.out.println(cust.getFirstName() + " " + cust.getLastName());
//
//        } catch (NoResultException ex) {
//            ex.printStackTrace();
//
//        } finally {
//            em.close();
//        }
//    }


}
