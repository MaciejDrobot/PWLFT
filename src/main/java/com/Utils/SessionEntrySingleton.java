package com.Utils;

import com.Model.Exercise;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SessionEntrySingleton {

    private List<Exercise> list = new ArrayList<>();

    private final static SessionEntrySingleton instance = new SessionEntrySingleton();

    public static SessionEntrySingleton getInstance() {
        return instance;
    }
}
