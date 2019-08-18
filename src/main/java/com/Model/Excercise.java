package com.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "excercise")


public class Excercise extends SessionStats {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    @JoinColumn(name = "session_id")
    private TrainingSession session;

    @Column(name = "name")
    private String name;

    @Column(name = "lift_mark")
    private String liftMark;

    @Column(name = "repetition_mark")
    private String repetitionMark;

    @Transient
    private List<TrainingSet> setsRecord = new ArrayList<TrainingSet>();

    @Column(name = "sets_record")
    private String setsRecordAsString;

    @Column(name = "one_rm")
    private Double oneRM;

    @Column(name = "volume")
    private Double volume;

    @Column(name = "intensity")
    private Double intensity;

    @Column(name = "total_reps")
    private int totalReps;

    @Column(name = "top_set")
    private String topSet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLiftMark() {
        return liftMark;
    }

    public void setLiftMark(String liftMark) {
        this.liftMark = liftMark;
    }

    public String getRepetitionMark() {
        return repetitionMark;
    }

    public void setRepetitionMark(String repetitionMark) {
        this.repetitionMark = repetitionMark;
    }

    public List<TrainingSet> getSetsRecord() {
        return setsRecord;
    }

    public void setSetsRecord(List<TrainingSet> setsRecord) {
        this.setsRecord = setsRecord;
    }

    public String getSetsRecordAsString() {
        return setsRecordAsString;
    }

    public void setSetsRecordAsString(String setsRecordAsString) {
        this.setsRecordAsString = setsRecordAsString;
    }

    public Double getOneRM() {
        return oneRM;
    }

    public void setOneRM(Double oneRM) {
        this.oneRM = oneRM;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getIntensity() {
        return intensity;
    }

    public void setIntensity(Double intensity) {
        this.intensity = intensity;
    }

    public int getTotalReps() {
        return totalReps;
    }

    public void setTotalReps(int totalReps) {
        this.totalReps = totalReps;
    }

    public String getTopSet() {
        return topSet;
    }

    public void setTopSet(String topSet) {
        this.topSet = topSet;
    }

    public TrainingSession getSession() {
        return session;
    }

    public void setSession(TrainingSession session) {
        this.session = session;
    }


}


