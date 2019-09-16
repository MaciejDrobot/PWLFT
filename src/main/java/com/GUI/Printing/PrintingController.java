package com.GUI.Printing;

import com.Model.Exercise;
import com.Model.TrainingSession;
import com.Utils.AllSessions;
import com.Utils.Filters;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PrintingController {

    public Button print;
    public AnchorPane root;
    public TextFlow textField;
    public DatePicker date;

    private List<TrainingSession> allSessions = new ArrayList<>();

    public void initialize() {
        allSessions = AllSessions.getInstance().getAllSessions();
    }

    //todo - methods: print session;
    public void printTrainingSession() {
        TrainingSession session = Filters.getSessionByDate(allSessions, date.getValue());
        textField.getChildren().clear();
        for (Exercise e : session.getExerciseList()) {
            Text t1 = new Text(e.getName());
            Text t2 = new Text("\n");
            Text t3 = new Text(e.getSetsRecordAsString());
            Text t4 = new Text("\n");
            textField.getChildren().addAll(t1, t2, t3, t4);
        }
    }
}
