package com.Model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data

@Entity
@NamedQuery(name = "singleSession",query = "FROM TrainingSession T WHERE T.date = :singleDate")
@NamedQuery(name = "betweenDates",query = "FROM TrainingSession T WHERE T.date BETWEEN :firstDate AND :secondDate")

@Table(name = "training_session")
public class TrainingSession {

    @Id
    @Column(name = "session_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sessioniId;

    //ToDo Change type for date
    @Column(name = "date")
    private LocalDate date;

    @OneToMany(mappedBy = "trainingSession")
    private List<Excercise> excerciseList = new ArrayList<>();

    public TrainingSession() {

    }


}
