package com.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "training_session")
public class TrainingSession {

    @Id
    @Column(name = "session_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sessioniId;

    //ToDo Change type for date
    @Column(name = "date")
    private String date;



    @OneToMany(mappedBy = "trainingSession")
    private List<Excercise> excerciseList = new ArrayList<>();


    public TrainingSession() {

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void addExcercise(Excercise ex) {
        this.excerciseList.add(ex);
    }

    public List<Excercise> getExcerciseList() {
        return excerciseList;
    }

    public long getSessioniId() {
        return sessioniId;
    }

    public void setSessioniId(long sessioniId) {
        this.sessioniId = sessioniId;
    }

    public void setExcerciseList(List<Excercise> excerciseList) {
        this.excerciseList = excerciseList;
    }
}
