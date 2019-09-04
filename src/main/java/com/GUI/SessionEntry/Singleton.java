package com.GUI.SessionEntry;

import com.Model.Excercise;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Singleton {

    private List<Excercise> list = new ArrayList<>();
    private Excercise ex1 = new Excercise();
    private Excercise ex2 = new Excercise();
    private Excercise ex3 = new Excercise();
    private Excercise ex4 = new Excercise();
    private Excercise ex5 = new Excercise();
    private String name;

    private final static Singleton instance = new Singleton();

    public Excercise getEx1() {
        return ex1;
    }

    public void setEx1(Excercise ex1) {
        this.ex1 = ex1;
    }

    public static Singleton getInstance() {
        return instance;
    }


    public Excercise getEx2() {
        return ex2;
    }

    public List<Excercise> getList() {
        return list;
    }

    public void setList(List<Excercise> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEx2(Excercise ex2) {
        this.ex2 = ex2;
    }

    public Excercise getEx3() {
        return ex3;
    }

    public void setEx3(Excercise ex3) {
        this.ex3 = ex3;
    }

    public Excercise getEx4() {
        return ex4;
    }

    public void setEx4(Excercise ex4) {
        this.ex4 = ex4;
    }

    public Excercise getEx5() {
        return ex5;
    }

    public void setEx5(Excercise ex5) {
        this.ex5 = ex5;
    }
}
