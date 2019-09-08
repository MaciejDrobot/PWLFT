package com.GUI.Graphs;

import com.Model.Exercise;
import com.Utils.AllPrimary;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GraphsAllinOneController {

    public Button printChart = new Button();
    public DatePicker firstDate = new DatePicker();
    public DatePicker secondDate = new DatePicker();
    public RadioButton x5 = new RadioButton();
    public RadioButton x3 = new RadioButton();

    @FXML
    CategoryAxis xAxis = new CategoryAxis();
    @FXML
    NumberAxis yAxis = new NumberAxis();
    @FXML
    private LineChart OneRM = new LineChart(xAxis, yAxis);
    @FXML
    private LineChart Volume = new LineChart(xAxis, yAxis);

    private LocalDate date1 = firstDate.getValue();
    private LocalDate date2 = secondDate.getValue();
    
    private List<Exercise> allExercises = new ArrayList<>();

    public void initialize() {
        allExercises = AllPrimary.getInstance().getAllPrimary();
        OneRM.setLegendVisible(false);
        Volume.setLegendVisible(false);

    }

    //todo add filtering methods
    public List<Exercise> filterExercises(){
        List<Exercise> list = allExercises;
        return list;
    }

    public void addDataChart(){

        List<Exercise> list = allExercises;

        XYChart.Series<String, Double> series = new XYChart.Series();
        series.setName("One RM");
        for (Exercise e : list){
            series.getData().add(new XYChart.Data(e.getDate().toString(), e.getOneRM()));
        }
        OneRM.getData().add(series);

        XYChart.Series<String, Double> series2 = new XYChart.Series<>();
        series.setName("Volume");
        for (Exercise e : list){
            series2.getData().add(new XYChart.Data(e.getDate().toString(), e.getVolume()));
        }
        Volume.getData().add(series2);
    }

}

