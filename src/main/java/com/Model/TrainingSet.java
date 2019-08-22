package com.Model;


public class TrainingSet {

    private int rep;
    private double load;

    public TrainingSet(int rep, double load) {
        this.rep = rep;
        this.load = load;
    }

    public TrainingSet(){

    }

    public double getRep(){
        return rep;
    }

    public void setRep(int rep){
        this.rep = rep;
    }

    public double getLoad() {
        return load;
    }

    public void setLoad(double load) {
        this.load = load;
    }

    @Override
    public String toString() {
        return "set[" + rep + " x " + load + "]";
    }
}
