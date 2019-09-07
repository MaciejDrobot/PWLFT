package com.Utils;

import com.Model.TrainingSession;
import lombok.Data;

import java.util.List;

@Data
public class AllData {

    private List<TrainingSession> allData = ExerciseQueries.getAllData();

    private final static AllData instance = new AllData();

    public static AllData getInstance() {
        return instance;
    }

}
