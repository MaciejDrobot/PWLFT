package com.Model;

import javax.persistence.*;


@Entity
@Table(name = "training_session")
public class TrainingSession extends Excercise {

    @Id
    @Column(name = "id", unique = true)
    private int id;

    //ToDo Change type for date
    @Column(name = "date")
    private String date;

    //@Column(name = "ex1")
    @OneToOne(mappedBy = "session",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Excercise ex1;

//    @Column(name = "ex2")
//    private Excercise ex2;
//
//    @Column(name = "ex3")
//    private Excercise ex3;
//
//    @Column(name = "ex4")
//    private Excercise ex4;
//
//    @Column(name = "ex5")
//    private Excercise ex5;


    public TrainingSession() {

    }

    public TrainingSession(String date, Excercise ex1, Excercise ex2, Excercise ex3, Excercise ex4, Excercise ex5) {
        this.date = date;
        this.ex1 = ex1;
//        this.ex2 = ex2;
//        this.ex3 = ex3;
//        this.ex4 = ex4;
//        this.ex5 = ex5;
    }

    public TrainingSession(String date, Excercise ex1) {
        this.date = date;
        this.ex1 = ex1;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Excercise getEx1() {
        return ex1;
    }

    public void setEx1(Excercise ex1) {
        this.ex1 = ex1;
    }

//    public Excercise getEx2() {
//        return ex2;
//    }
//
//    public void setEx2(Excercise ex2) {
//        this.ex2 = ex2;
//    }
//
//    public Excercise getEx3() {
//        return ex3;
//    }
//
//    public void setEx3(Excercise ex3) {
//        this.ex3 = ex3;
//    }
//
//    public Excercise getEx4() {
//        return ex4;
//    }
//
//    public void setEx4(Excercise ex4) {
//        this.ex4 = ex4;
//    }
//
//    public Excercise getEx5() {
//        return ex5;
//    }
//
//    public void setEx5(Excercise ex5) {
//        this.ex5 = ex5;
//    }
}
