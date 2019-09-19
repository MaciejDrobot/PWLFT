package com.GUI.SessionEntry;

import com.Model.Exercise;
import com.Model.TrainingSet;
import com.Utils.SessionEntrySingleton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import lombok.Data;

@Data
public class EntryPaneController {

    @FXML
    private ChoiceBox<String> liftMark = new ChoiceBox<>();
    @FXML
    private TextField exName = new TextField();
    @FXML
    private TextField exSets = new TextField();
    @FXML
    private TextField exReps = new TextField();
    @FXML
    private TextField exLoad = new TextField();
    @FXML
    private Button addSet = new Button();
    @FXML
    private Button removeSet = new Button();

    public Exercise exercise = new Exercise();

    public void initialize(){
        liftMark.getItems().addAll("PRM", "SEC", "ACC");
        liftMark.setValue("ACC");
    }

    public void addSet() {
        Integer reps = new Integer(exReps.getText()).intValue();
        Double load = new Double(exLoad.getText()).doubleValue();
        TrainingSet set = new TrainingSet(reps, load);
        exercise.getSetsRecord().add(set);
        exSets.setText(exercise.recordToString(exercise.getSetsRecord()));
        removeSet.setDisable(false);
    }

    public void removeSet() {
        if (exercise.getSetsRecord().size() > 1) {
            exercise.getSetsRecord().remove((exercise.getSetsRecord().size() - 1));
            exSets.setText(exercise.recordToString(exercise.getSetsRecord()));
        } else {
            exercise.getSetsRecord().remove(0);
            exSets.setText("");
            removeSet.setDisable(true);
        }
    }

    public void addExercise(){
        exercise.setLiftMark(liftMark.getValue());
        exercise.setName(exName.getText());
        if(exercise.getSetsRecord().isEmpty() == false){
            exercise.addSessionStats(exercise, exercise.getSetsRecord());
        }
        SessionEntrySingleton.getInstance().getList().add(exercise);
    }
}
