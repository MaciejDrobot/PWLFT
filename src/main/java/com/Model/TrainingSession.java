package com.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data

@Entity
@NamedQuery(name = "findByDate",query = "From TrainingSession D where D.date = :name_param")
@Table(name = "training_session")
public class TrainingSession {

    @Id
    @Column(name = "session_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sessioniId;

    //ToDo Change type for date
    @Column(name = "date")
    private String date;

    @OneToMany(mappedBy = "trainingSession")
    private List<Excercise> excerciseList = new ArrayList<>();

    public TrainingSession() {

    }


}
