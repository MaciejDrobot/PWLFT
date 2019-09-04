package com.GUI.SessionEntry;

import com.Model.Excercise;
import com.Model.TrainingSession;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import lombok.Data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Data
public class SessionEntryController {

    private TrainingSession session = new TrainingSession();


    public DatePicker date = new DatePicker();

    public Button save = new Button();
    public TextArea comments = new TextArea();


    public void printExcercise() {
        //Singleton.getInstance().getEx1().setName();
        comments.setText(Singleton.getInstance().getList().get(0).toString());


    }


    //todo simplify method
    public void createSession() {
        session.setDate(date.getValue());
        //session.getExcerciseList().add(ex1);
        //session.getExcerciseList().add(ex2);

        for (Excercise e : session.getExcerciseList()) {
            if (e.getName() != null) {
                e.setDate(date.getValue());
                e.setTrainingSession(session);
            }
        }
    }

    public void saveSession() {
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("PWLFT");

        EntityManager entityManager
                = entityManagerFactory.createEntityManager();

        System.out.println("Is ok: " + entityManager.isOpen());

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        createSession();
        for (Excercise e : session.getExcerciseList()) {
            entityManager.persist(e);
        }
        entityManager.persist(session);

        tx.commit();
        entityManager.close();
        entityManagerFactory.close();
    }


}

