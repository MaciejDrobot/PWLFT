package com.utils;

import com.model.Exercise;
import com.model.TrainingSession;

import javax.persistence.*;
import java.util.List;

public class Queries {

    private static EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("PWLFT");


    public static List<Exercise> getPrimaryExercises() {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        List<Exercise> primaryQ;
        TypedQuery<Exercise> query = entityManager.createNamedQuery("primaryExercises", Exercise.class);
        query.setParameter("liftMark", "PRM");
        primaryQ = query.getResultList();
        try {
            return primaryQ;
        } catch (NoResultException ex) {
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
        return primaryQ;
    }

    public static List<TrainingSession> getAllSessions() {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        List<TrainingSession> sessionQ;
        TypedQuery<TrainingSession> query = entityManager.createNamedQuery("getAllSessions", TrainingSession.class);
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

    //todo add removal and amending queries/methods

}
