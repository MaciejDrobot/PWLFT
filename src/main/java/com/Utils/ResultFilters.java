package com.Utils;

import com.Model.Exercise;

import java.util.List;
import java.util.stream.Collectors;

public abstract class ResultFilters {

    public List<Exercise> filteredExcercises(List<Exercise> list, String name) {
        List<Exercise> filtered = list.stream()
                .filter(e -> e.getName().contains(name))
                .collect(Collectors.toList());
        return filtered;
    }


}