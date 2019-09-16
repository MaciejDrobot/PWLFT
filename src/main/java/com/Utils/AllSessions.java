package com.Utils;

import com.Model.TrainingSession;
import lombok.Data;

import java.util.List;

@Data
public class AllSessions {

    private List<TrainingSession> allSessions = Queries.getAllSessions();

    private final static AllSessions instance = new AllSessions();

    public static AllSessions getInstance() {
        return instance;
    }

    public List<TrainingSession> getAllSessions() {
        return allSessions;
    }
}
