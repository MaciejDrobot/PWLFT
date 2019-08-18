package com.Model;

public class TrainingSet {

    private double rep;
    private double load;

    public TrainingSet(double rep, double load) {
        this.rep = rep;
        this.load = load;
    }

    public TrainingSet(){

    }

    public double getRep(){
        return rep;
    }

    public void setRep(double rep){
        this.rep = rep;
    }

    public double getLoad() {
        return load;
    }

    public void setLoad(double load) {
        this.load = load;
    }
}
