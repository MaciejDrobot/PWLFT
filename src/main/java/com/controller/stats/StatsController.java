package com.controller.stats;

import com.model.Exercise;
import com.utils.AllPrimary;
import com.utils.Filters;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class StatsController {

    public Button printChart = new Button();
    public DatePicker firstDate = new DatePicker();
    public DatePicker secondDate = new DatePicker();
    public CheckBox reps5 = new CheckBox();
    public CheckBox reps3 = new CheckBox();
    public ChoiceBox<String> exercise = new ChoiceBox();
    public Label label = new Label();

    @FXML
    CategoryAxis xAxis = new CategoryAxis();
    @FXML
    NumberAxis yAxis = new NumberAxis();
    @FXML
    private LineChart OneRM = new LineChart(xAxis, yAxis);
    @FXML
    private LineChart Volume = new LineChart(xAxis, yAxis);

    private List<Exercise> allExercises = new ArrayList<>();

    public void initialize() {
        allExercises = AllPrimary.getInstance().getAllPrimary();
        exercise.getItems().addAll("Bench", "Squat", "Deadlift");
        OneRM.setLegendVisible(false);
        OneRM.setAnimated(false);
        Volume.setLegendVisible(false);
        Volume.setAnimated(false);
    }

    public List<Exercise> filterExercises(){
        //allExercises = AllPrimary.getInstance().getAllPrimary();
        String x3 = new String();
        String x5 = new String();
        if (reps3.isSelected()){
            x3 = "x3";
        }
        if (reps5.isSelected()){
            x5 = "x5";
        }
        List<Exercise> list = Filters.getExercisesBetweenDates(allExercises, firstDate.getValue(), secondDate.getValue());
        list = Filters.getExerciseByName(list, exercise.getValue());
        list = Filters.filterRepsMark(list, x3, x5);
        list = Filters.sortExercisesByDate(list);
        return list;
    }

    public void addDataChart(){

        List<Exercise> list = filterExercises();
        label.setText(exercise.getValue());

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

