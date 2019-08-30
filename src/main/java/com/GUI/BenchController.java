package com.GUI;

import com.Model.Excercise;
import com.Utils.ExcerciseQueries;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

import java.util.List;
import static com.Utils.ResultFilters.filteredExcercises;

public class BenchController {

    private ExcerciseQueries eq;

    @FXML
    private DatePicker firstDate = new DatePicker();
    @FXML
    private DatePicker secondDate = new DatePicker();
    @FXML
    TextArea printResult = new TextArea();
    @FXML
    Button printRes = new Button();

    public void  printFilteredResults(){
        List<Excercise> downloaded = eq.getPrimaryExcercises("sec");
        List<Excercise> filteredList = filteredExcercises(downloaded, "RDL");
        String list = "";
        for (Excercise e : filteredList){
            list += (e.getName() + "   " + e.getVolume() + "  ");
            printResult.setText(list);
        }
    }




//    private ObservableList<XYChart.Series<String, Double>> getChartData() {
//
//        ObservableList<XYChart.Series<String, Double>> answer = FXCollections
//
//                .observableArrayList();
//
//        Series<String, Double> oneRMSeries = new Series<String, Double>();
//
//        Series<String, Double> volumeSeries = new Series<String, Double>();
//
//        oneRMSeries.setName("1RM");
//
//        volumeSeries.setName("Volume");
//
//        for (Exercise e : filteredQuery) {
//
//            oneRMSeries.getData().add(new XYChart.Data(e.getDate.toString(), e.getOneRM));
//
//            volumeSeries.getData().add(new XYChart.Data(e.getDate.toString(), e.getVolume));
//
//        }
//
//        answer.addAll(oneRMSeries, volumeSeries);
//
//        return answer;
//
//    }


}
