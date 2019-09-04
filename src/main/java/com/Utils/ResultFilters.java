package com.Utils;

import com.Model.Excercise;

import java.util.List;
import java.util.stream.Collectors;

public abstract class ResultFilters {

    public List<Excercise> filteredExcercises(List<Excercise> list, String name){
        List<Excercise> filtered = list.stream()
                .filter(e -> e.getName().contains(name))
                .collect(Collectors.toList());
        return filtered;
    }
}
