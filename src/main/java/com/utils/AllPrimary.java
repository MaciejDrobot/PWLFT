package com.utils;

import com.model.Exercise;
import lombok.Data;

import java.util.List;

@Data
public class AllPrimary {

    private List<Exercise> allPrimary = Queries.getPrimaryExercises();

    private final static AllPrimary instance = new AllPrimary();

    public static AllPrimary getInstance() {
        return instance;
    }

}
