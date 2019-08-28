package com.Utils;

import com.Model.Excercise;

import java.util.List;
import java.util.stream.Collectors;

public class ResultFilters {

    //private List<Excercise> sessionPrimary;

    public static List<Excercise> filteredExcercises(List<Excercise> primaryList, String name){
        primaryList.stream()
                .filter(e -> e.getName().contains(name))
                .collect(Collectors.toList());
        return primaryList;
    }
}
