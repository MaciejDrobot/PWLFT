package com.GUI.SessionEntry;

import com.Model.Excercise;
import com.Model.TrainingSet;
import com.Utils.ResultFilters;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lombok.Data;

@Data
public class EntryPaneController extends ResultFilters {

    Excercise ex = new Excercise();

    public TextField Mark = new TextField();
    public TextField Name = new TextField();
    public TextField Sets = new TextField();
    public TextField Reps = new TextField();
    public TextField Load = new TextField();
    public Button addSet;
    public Button removeSet;


    public void addSet() {
        Integer reps = new Integer(Reps.getText()).intValue();
        Double load = new Double(Load.getText()).doubleValue();
        TrainingSet set = new TrainingSet(reps, load);
        ex.getSetsRecord().add(set);
        Sets.setText(ex.recordToString(ex.getSetsRecord()));
        removeSet.setDisable(false);
    }

    public void removeSet() {
        if (ex.getSetsRecord().size() > 1) {
            ex.getSetsRecord().remove((ex.getSetsRecord().size() - 1));
            Sets.setText(ex.recordToString(ex.getSetsRecord()));
        } else {
            ex.getSetsRecord().remove(0);
            Sets.setText("");
            removeSet.setDisable(true);
        }
    }
}
