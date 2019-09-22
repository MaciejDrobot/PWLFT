package com.controller.printing;

import com.model.Exercise;
import com.model.TrainingSession;
import com.utils.AllSessions;
import com.utils.Filters;
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

    //todo - methods: print trainingSession;
    public void printTrainingSession() {
        textField.getChildren().clear();
        TrainingSession session = Filters.getSessionByDate(allSessions, date.getValue());
        for (Exercise e : session.getExerciseList()) {
            Text t1 = new Text(e.getName());
            Text t2 = new Text("\n");
            Text t3 = new Text(e.getSetsRecordAsString());
            Text t4 = new Text("\n");
            textField.getChildren().addAll(t1, t2, t3, t4);
        }
    }
}
