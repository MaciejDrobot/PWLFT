package com.GUI;

import com.Model.Excercise;
import com.Model.TrainingSession;
import com.Model.TrainingSet;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Controller {


    private TrainingSession session = new TrainingSession();
    private Excercise ex1 = new Excercise();
    private Excercise ex2 = new Excercise();

    public TextField date = new TextField();

    public TextField e1Mark = new TextField();
    public TextField e1Name = new TextField();
    public TextField e1RepMark = new TextField();
    public TextField e1Sets = new TextField();
    public TextField e1Reps = new TextField();
    public TextField e1Load = new TextField();
    public Button addSetE1;
    public Button removeSetE1;

    public TextField e2Mark = new TextField();
    public TextField e2Name = new TextField();
    public TextField e2RepMark = new TextField();
    public TextField e2Sets = new TextField();
    public TextField e2Reps = new TextField();
    public TextField e2Load = new TextField();
    public Button addSetE2;
    public Button removeSetE2;

    public Button save = new Button();


    public void addSetE1() {
        Integer reps = new Integer(e1Reps.getText()).intValue();
        Double load = new Double(e1Load.getText()).doubleValue();
        TrainingSet set = new TrainingSet(reps, load);
        ex1.getSetsRecord().add(set);
        e1Sets.setText(ex1.recordToString(ex1.getSetsRecord()));
        removeSetE1.setDisable(false);
    }

    public void removeSetE1() {
        if (ex1.getSetsRecord().size() > 1) {
            ex1.getSetsRecord().remove((ex1.getSetsRecord().size() - 1));
            e1Sets.setText(ex1.recordToString(ex1.getSetsRecord()));
        } else {
            ex1.getSetsRecord().remove(0);
            e1Sets.setText("");
            removeSetE1.setDisable(true);
        }
    }

    public void addSetE2() {
        Integer reps = new Integer(e2Reps.getText()).intValue();
        Double load = new Double(e2Load.getText()).doubleValue();
        TrainingSet set = new TrainingSet(reps, load);
        ex2.getSetsRecord().add(set);
        e2Sets.setText(ex1.recordToString(ex2.getSetsRecord()));
        removeSetE2.setDisable(false);
    }

    public void removeSetE2() {
        if (ex2.getSetsRecord().size() > 1) {
            ex2.getSetsRecord().remove((ex2.getSetsRecord().size() - 1));
            e2Sets.setText(ex2.recordToString(ex2.getSetsRecord()));
        } else {
            ex2.getSetsRecord().remove(0);
            e2Sets.setText("");
            removeSetE2.setDisable(true);

        }
    }

    //todo simplify method
    public void saveSession() {
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("PWLFT");

        EntityManager entityManager
                = entityManagerFactory.createEntityManager();

        System.out.println("Is ok: " + entityManager.isOpen());

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        ex1.setLiftMark(e1Mark.getText());
        ex1.setName(e1Name.getText());
        ex1.setRepetitionMark(e1RepMark.getText());
        ex1.addSessionStats(ex1);

        ex2.setLiftMark(e2Mark.getText());
        ex2.setName(e2Name.getText());
        ex2.setRepetitionMark(e2RepMark.getText());
        ex2.addSessionStats(ex2);

        session.setDate(date.getText());
        session.getExcerciseList().add(ex1);
        session.getExcerciseList().add(ex2);

        ex1.setTrainingSession(session);
        ex2.setTrainingSession(session);

        entityManager.persist(ex1);
        entityManager.persist(ex2);
        entityManager.persist(session);

        tx.commit();
        entityManager.close();
        entityManagerFactory.close();
        System.exit(0);

    }


}

