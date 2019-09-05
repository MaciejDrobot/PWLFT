package com.GUI.SessionEntry;

import com.Model.Excercise;
import com.Model.TrainingSet;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lombok.Data;

@Data
public class EP1 extends EntryPaneController  {

    @FXML
    public TextField liftMark = new TextField();
    @FXML
    public TextField exName = new TextField();
    @FXML
    public TextField exSets = new TextField();
    @FXML
    public TextField exReps = new TextField();
    @FXML
    public TextField exLoad = new TextField();
    @FXML
    public Button addEX = new Button();

    public Excercise excercise = new Excercise();

    public void addSet() {
        Integer reps = new Integer(exReps.getText()).intValue();
        Double load = new Double(exLoad.getText()).doubleValue();
        TrainingSet set = new TrainingSet(reps, load);
        excercise.getSetsRecord().add(set);
        exSets.setText(excercise.recordToString(excercise.getSetsRecord()));
        removeSet.setDisable(false);
    }

    public void removeSet() {
        if (excercise.getSetsRecord().size() > 1) {
            excercise.getSetsRecord().remove((excercise.getSetsRecord().size() - 1));
            exSets.setText(ex.recordToString(excercise.getSetsRecord()));
        } else {
            excercise.getSetsRecord().remove(0);
            exSets.setText("");
            removeSet.setDisable(true);
        }
    }

    public void setEx1(){
        excercise.setLiftMark(liftMark.getText());
        excercise.setName(exName.getText());
        excercise.addSessionStats(excercise, excercise.getSetsRecord());
        Singleton.getInstance().getList().add(excercise);
    }
}
