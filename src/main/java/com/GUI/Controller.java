package com.GUI;

import com.Model.Excercise;
import com.Model.TrainingSession;
import com.Model.TrainingSet;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {


    private TrainingSession session = new TrainingSession();
    private Excercise ex1 = new Excercise();
    private Excercise ex2 = new Excercise();

    public TextField e1Mark = new TextField();
    public TextField e1Name = new TextField();
    public TextField e1RepMark = new TextField();
    public TextField e1Sets = new TextField();
    public TextField e1Reps = new TextField();
    public TextField e1Load = new TextField();
    public Button addSetE1;
    public Button removeSet;


    public void addSet() {
        Integer reps = new Integer(e1Reps.getText()).intValue();
        Double load = new Double(e1Load.getText()).doubleValue();
        TrainingSet set = new TrainingSet(reps, load);
        ex1.getSetsRecord().add(set);
        e1Sets.setText(ex1.recordToString(ex1.getSetsRecord()));
    }

    public void removeLastSet(){
        if(ex1.getSetsRecord().size() == 0){
            e1Sets.setText("");
        }
        ex1.getSetsRecord().remove(ex1.getSetsRecord().size() - 1);
        e1Sets.setText(ex1.recordToString(ex1.getSetsRecord()));
    }

}

