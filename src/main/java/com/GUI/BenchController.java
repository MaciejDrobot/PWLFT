package com.GUI;

import com.Model.Excercise;
import com.Utils.ExcerciseQueries;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.util.List;

public class BenchController {


    @FXML
    private DatePicker firstDate = new DatePicker();
    @FXML
    private DatePicker secondDate = new DatePicker();
    @FXML
    private Button printChart = new Button();
    @FXML
    CategoryAxis xAxis = new CategoryAxis();
    @FXML
    NumberAxis yAxis = new NumberAxis();
    @FXML
    private LineChart benchChart = new LineChart(xAxis, yAxis);
    @FXML
    private TextArea print = new TextArea();


    private LocalDate date1 = firstDate.getValue();
    private LocalDate date2 = secondDate.getValue();

    //LocalDate date1 = LocalDate.now().minusDays(35);
    //LocalDate date2 = LocalDate.now();

    private ExcerciseQueries eq;


    public void addDataChart(){
        List<Excercise> list = downloadData("Bench");

        XYChart.Series<String, Double> series = new XYChart.Series<String, Double>();
        series.setName("One RM");
        for (Excercise e : list){
            series.getData().add(new XYChart.Data<String, Double>(e.getDate().toString(), e.getOneRM()));
        }
        benchChart.getData().add(series);

        XYChart.Series<String, Double> series2 = new XYChart.Series<String, Double>();
        series.setName("Volume");
        for (Excercise e : list){
            series2.getData().add(new XYChart.Data<String, Double>(e.getDate().toString(), e.getVolume()));
        }
        benchChart.getData().add(series2);
    }


    public static List<Excercise> downloadData (String excercise){
        ExcerciseQueries eq = new ExcerciseQueries();
        List<Excercise> downloadedPrimary = eq.getPrimaryExcercises();
        return eq.filteredExcercises(downloadedPrimary, excercise);
    }

}
