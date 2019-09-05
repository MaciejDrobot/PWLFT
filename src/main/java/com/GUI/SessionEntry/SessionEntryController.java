package com.GUI.SessionEntry;

import com.Model.Exercise;
import com.Model.TrainingSession;
import javafx.fxml.FXML;
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

    @FXML
    private DatePicker date = new DatePicker();
    @FXML
    private Button save = new Button();
    @FXML
    private TextArea comments = new TextArea();

    @FXML
    private EntryPaneController pane1Controller;
    @FXML
    private EntryPaneController pane2Controller;


    public void printExercise() {
        pane1Controller.addExercise();
        pane2Controller.addExercise();
        comments.setText(Singleton.getInstance().getList().toString());
    }


    //todo simplify method
    public void createSession() {
        session.setDate(date.getValue());
        //session.getExcerciseList().add(ex1);
        //session.getExcerciseList().add(ex2);

        for (Exercise e : session.getExerciseList()) {
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
        for (Exercise e : session.getExerciseList()) {
            entityManager.persist(e);
        }
        entityManager.persist(session);

        tx.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

}


