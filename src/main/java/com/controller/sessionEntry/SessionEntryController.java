package com.controller.sessionEntry;

import com.model.Exercise;
import com.model.TrainingSession;
import com.utils.SessionEntrySingleton;
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

    private TrainingSession trainingSession = new TrainingSession();

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

    EntityManagerFactory entityManagerFactory
            = Persistence.createEntityManagerFactory("PWLFT");
    EntityManager entityManager
            = entityManagerFactory.createEntityManager();
    EntityTransaction tx = entityManager.getTransaction();

    public void initialize(){
        pane1Controller.getLiftMark().setValue("PRM");
        pane2Controller.getLiftMark().setValue("PRM");
        comments.setText("Comments");

        //temporary fill TODO remove after testing
        pane1Controller.getExName().setText("Bench");
        pane1Controller.getExReps().setText("3");
        pane1Controller.getExLoad().setText("80");
        pane2Controller.getExName().setText("Deadlift");
        pane2Controller.getExReps().setText("3");
        pane2Controller.getExLoad().setText("140");
        pane3Controller.getExName().setText("Press");
        pane3Controller.getExReps().setText("3");
        pane3Controller.getExLoad().setText("60");
    }

    private void addExercise() {
        pane1Controller.addExercise();
        pane2Controller.addExercise();
        pane3Controller.addExercise();
        pane4Controller.addExercise();
        pane5Controller.addExercise();
    }

    private void createTrainingSession() {
        addExercise();
        trainingSession.setDate(date.getValue());
        trainingSession.setComments(comments.getText());
        for (Exercise e : SessionEntrySingleton.getInstance().getList()){
            if(e.getSetsRecord().isEmpty() == false){
                trainingSession.getExerciseList().add(e);
            }
        }
        for (Exercise e : trainingSession.getExerciseList()) {
                e.setDate(date.getValue());
                e.setTrainingSession(trainingSession);
            }
        }

    public void saveSession() {
        tx.begin();
        createTrainingSession();
        entityManager.persist(trainingSession);
        tx.commit();
        entityManager.close();
        entityManagerFactory.close();
        save.setDisable(true);
        //todo pop up window "SAVED!"
    }
}



