package com.GUI.Printing;

import com.Model.TrainingSession;
import com.Utils.ExerciseQueries;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
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

    private int layoutY = 50;
    private ExerciseQueries eq;
    private List<TrainingSession> allSessions = new ArrayList<>();

//    public void initialize() {
//
//        allSessions = eq.getAllData();
//    }


    //todo - methods: initialize - get data; filtering + run button; print session;

    public void printStats(){
        allSessions = eq.getAllData();
        text.setText(allSessions.get(0).toString());
    }



    public void printBasic(int layoutY) {
        FXMLLoader loader = new FXMLLoader();
        try {
            AnchorPane stats = loader.load(getClass().getResource("/FXML/Printing/BasicInfo.fxml"));
            stats.setLayoutY(layoutY);
            root.getChildren().add(stats);

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

    public void printSeparator(int layoutY){
        FXMLLoader loader = new FXMLLoader();
        try {
            AnchorPane stats = loader.load(getClass().getResource("/FXML/Printing/Separator.fxml"));
            stats.setLayoutY(layoutY);
            root.getChildren().add(stats);

        } catch(IOException iex) {
            System.out.println("Unable to load");
        }
    }

}
