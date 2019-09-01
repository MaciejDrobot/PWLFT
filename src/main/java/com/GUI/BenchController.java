package com.GUI;

import com.Model.Excercise;
import com.Utils.ExcerciseQueries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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


//    private LocalDate date1 = firstDate.getValue();
//    private LocalDate date2 = secondDate.getValue();

    LocalDate date1 = LocalDate.now().minusDays(35);
    LocalDate date2 = LocalDate.now();

    private ExcerciseQueries eq;


    public void addDataTest(){
        List<Excercise> list = downloadData ("Bench", date1, date2);
        XYChart.Series<String, Double> series = new XYChart.Series<String, Double>();
        series.setName("One RM");
        for (Excercise e : list){
            series.getData().add(new XYChart.Data<String, Double>(e.getDate().toString(), e.getOneRM()));
        }
//        series.getData().add(new XYChart.Data<String, Double>(list.get(0).getDate().toString(), list.get(0).getOneRM()));
//        series.getData().add(new XYChart.Data<String, Double>(list.get(1).getDate().toString(), list.get(1).getOneRM()));
////        //series.getData().add(new XYChart.Data<String, Double>("12", 110.0));
        benchChart.getData().add(series);
    }

    public List<Excercise> downloadData(String excercise){
        List<Excercise> betweenDates = eq.getPrimaryExcercisesBetweenDates(date1, date2);
        return eq.filteredExcercises(betweenDates, excercise);
    }

    public static List<Excercise> downloadData (String excercise, LocalDate date1, LocalDate date2){
        ExcerciseQueries eq = new ExcerciseQueries();
        List<Excercise> betweenDates = eq.getPrimaryExcercisesBetweenDates(date1, date2);
        return eq.filteredExcercises(betweenDates, excercise);
    }

    public void printDownloaded(){
        List<Excercise> list = downloadData ("Bench", date1, date2);
        print.setText(list.toString());
    }














    public ObservableList<XYChart.Series<String, Double>> addData() {

        List<Excercise> list = downloadData ("Bench", date1, date2);

        ObservableList<XYChart.Series<String, Double>> answer = FXCollections.observableArrayList();
        XYChart.Series<String, Double> oneRMSeries = new XYChart.Series<String, Double>();
        XYChart.Series<String, Double> volumeSeries = new XYChart.Series<String, Double>();
        oneRMSeries.setName("1RM");
        volumeSeries.setName("Volume");

        for (Excercise e : list) {
            oneRMSeries.getData().add(new XYChart.Data(e.getDate().toString(), e.getOneRM()));
            volumeSeries.getData().add(new XYChart.Data(e.getDate().toString(), e.getVolume()));
        }

        answer.addAll(oneRMSeries, volumeSeries);
        return answer;
    }


}
