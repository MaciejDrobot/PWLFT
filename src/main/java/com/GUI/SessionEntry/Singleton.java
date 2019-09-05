package com.GUI.SessionEntry;

import com.Model.Excercise;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Singleton {

    private List<Excercise> list = new ArrayList<>();

    private final static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}
