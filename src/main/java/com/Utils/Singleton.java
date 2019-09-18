package com.Utils;

import com.Model.Exercise;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Singleton {

    private List<Exercise> list = new ArrayList<>();

    private final static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}
