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
    @FXML
    private EntryPaneController pane3Controller;
    @FXML
    private EntryPaneController pane4Controller;
    @FXML
    private EntryPaneController pane5Controller;


    public void initialize(){


        pane1Controller.getLiftMark().setValue("PRM");
        pane2Controller.getLiftMark().setValue("PRM");
        comments.setText("Comments");

        //temporary fill
        pane1Controller.getExName().setText("Bench");
        pane1Controller.getExReps().setText("5");
        pane1Controller.getExLoad().setText("80");
        pane2Controller.getExName().setText("Deadlift");
        pane2Controller.getExReps().setText("5");
        pane2Controller.getExLoad().setText("140");
        pane3Controller.getExName().setText("Press");
        pane3Controller.getExReps().setText("5");
        pane3Controller.getExLoad().setText("60");
    }

    public void addExercise() {
        pane1Controller.addExercise();
        pane2Controller.addExercise();
        pane3Controller.addExercise();
        pane4Controller.addExercise();
        pane5Controller.addExercise();
    }

    public void createSession() {
        session.setDate(date.getValue());
        session.setComments(comments.getText());
        for (Exercise e : Singleton.getInstance().getList()){
            if(e.getSetsRecord().isEmpty() == false){
                session.getExerciseList().add(e);
            }
        }
        for (Exercise e : session.getExerciseList()) {
                e.setDate(date.getValue());
                e.setTrainingSession(session);
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

        addExercise();
        createSession();

        for (Exercise e : session.getExerciseList()) {
            entityManager.persist(e);
        }
        entityManager.persist(session);

        entityManager.flush();
        tx.commit();

        //entityManager.close();
        //entityManagerFactory.close();
    }

    //todo add session clearing method
}


