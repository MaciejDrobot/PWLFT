package com.GUI.Graphs;

import com.Model.Exercise;
import com.Utils.AllPrimary;
import com.Utils.Filters;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;

import java.util.ArrayList;
import java.util.List;

public class GraphsController {

    public Button printChart = new Button();
    public DatePicker firstDate = new DatePicker();
    public DatePicker secondDate = new DatePicker();
    public RadioButton x5 = new RadioButton("x5");
    public RadioButton x3 = new RadioButton("x3");
    public ChoiceBox<String> exercise = new ChoiceBox();

    @FXML
    CategoryAxis xAxis = new CategoryAxis();
    @FXML
    NumberAxis yAxis = new NumberAxis();
    @FXML
    private LineChart OneRM = new LineChart(xAxis, yAxis);
    @FXML
    private LineChart Volume = new LineChart(xAxis, yAxis);

    private List<Exercise> allExercises = new ArrayList<>();
    String repsX3 = x3.getText();
    String repsX5 = x5.getText();



    public void initialize() {
        allExercises = AllPrimary.getInstance().getAllPrimary();
        exercise.getItems().addAll("Bench", "Squat", "Deadlift");
        OneRM.setLegendVisible(false);
        OneRM.setAnimated(false);
        Volume.setLegendVisible(false);
        Volume.setAnimated(false);
    }

    //todo add filtering methods
    public List<Exercise> filterExercises(){
        List<Exercise> list = Filters.getExercisesBetweenDates(allExercises, firstDate.getValue(), secondDate.getValue());
        list = Filters.getExerciseByName(list, exercise.getValue());
        list = Filters.filterRepsMark(list, repsX3, repsX5);
        list = Filters.sortExercisesByDate(list);
        return list;
    }

    public void addDataChart(){

        List<Exercise> list = filterExercises();

        OneRM.getData().clear();
        XYChart.Series<String, Double> series = new XYChart.Series();
        series.setName("One RM");
        for (Exercise e : list){
            series.getData().add(new XYChart.Data(e.getDate().toString(), e.getOneRM()));
        }
        OneRM.getData().add(series);

        Volume.getData().clear();
        XYChart.Series<String, Double> series2 = new XYChart.Series<>();
        series.setName("Volume");
        for (Exercise e : list){
            series2.getData().add(new XYChart.Data(e.getDate().toString(), e.getVolume()));
        }
        Volume.getData().add(series2);
    }

}

