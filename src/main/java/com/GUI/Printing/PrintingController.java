package com.GUI.Printing;

import com.Model.TrainingSession;
import com.Utils.AllSessions;
import com.Utils.Filters;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lombok.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
public class PrintingController {


    public Button print;
    public AnchorPane root;
    public TextField text;
    public DatePicker date;

    private int layoutY = 50;
    private List<TrainingSession> allSessions = new ArrayList<>();

    public void initialize() {
        allSessions = AllSessions.getInstance().getAllSessions();
    }

    //todo - methods: print session;

    public void printStats() {
        TrainingSession session = Filters.getSessionByDate(allSessions, date.getValue());
        text.setText(session.toString());

    }

    public void printTrainingSession() {
        TrainingSession session = Filters.getSessionByDate(allSessions, date.getValue());
        //text.setText(session.getExerciseList().get(0).getName());
        printBasic(layoutY);
    }


    public void printBasic(int layoutY) {
        FXMLLoader loader = new FXMLLoader();
        try {
            AnchorPane basic = loader.load(getClass().getResource("/FXML/Printing/BasicInfo.fxml"));
            basic.setLayoutY(layoutY);
            root.getChildren().add(basic);
        } catch (IOException iex) {
            System.out.println("Unable to load");
        }
    }

    public void printStats(int layoutY) {
        FXMLLoader loader = new FXMLLoader();
        try {
            AnchorPane stats = loader.load(getClass().getResource("/FXML/Printing/Stats.fxml"));
            stats.setLayoutY(layoutY);
            root.getChildren().add(stats);

        } catch (IOException iex) {
            System.out.println("Unable to load");
        }
    }

    public void printSeparator(int layoutY) {
        FXMLLoader loader = new FXMLLoader();
        try {
            AnchorPane stats = loader.load(getClass().getResource("/FXML/Printing/Separator.fxml"));
            stats.setLayoutY(layoutY);
            root.getChildren().add(stats);

        } catch (IOException iex) {
            System.out.println("Unable to load");
        }
    }

}
