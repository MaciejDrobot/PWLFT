package com.Utils;

import com.Model.Exercise;
import com.Model.TrainingSession;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


public class ExerciseQueries {

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
            System.out.println(sessionQ.get(3).getExerciseList().get(1).toString());
        } catch (NoResultException ex) {
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public static List<Exercise> getPrimaryExercises() {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        List<Exercise> sessionQ;
        TypedQuery<Exercise> query = entityManager.createNamedQuery("primaryExercises", Exercise.class);
        query.setParameter("liftMark", "PRM");
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

    public List<Exercise> getPrimaryExercisesBetweenDates(LocalDate date1, LocalDate date2) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        List<Exercise> sessionQ;
        TypedQuery<Exercise> query = entityManager.createNamedQuery("primaryExercisesBetweenDates", Exercise.class);
        query.setParameter("liftMark", "PRM");
        query.setParameter("firstDate", date1);
        query.setParameter("secondDate", date2);
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
            System.out.println(sessionQ.getExerciseList().get(0).toString());
        } catch (NoResultException ex) {
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public List<Exercise> filteredExercises(List<Exercise> list, String name){
        List<Exercise> filtered = list.stream()
                .filter(e -> e.getName().contains(name))
                .collect(Collectors.toList());
        return filtered;
    }


    //todo add removal and amending queries/methods


}
