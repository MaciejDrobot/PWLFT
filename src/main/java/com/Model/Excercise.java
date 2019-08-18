package com.Model;

import java.util.ArrayList;
import java.util.List;



public class Excercise extends SessionStats {

    private String name;

    private String liftMark;
    private String repetitionMark;

    private List<TrainingSet> setsRecord = new ArrayList<TrainingSet>();

    private String setsRecordAsString;

    private Double oneRM;
    private Double volume;
    private Double intensity;
    private int totalReps;
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
}


