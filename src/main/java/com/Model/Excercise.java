package com.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data

@Entity
@Table(name = "excercise")


public class Excercise extends SessionStats {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private TrainingSession trainingSession;

    @Column(name = "name")
    private String name;

    @Column(name = "lift_mark")
    private String liftMark;

    @Column(name = "repetition_mark")
    private String repetitionMark;

    @Transient
    private List<TrainingSet> setsRecord = new ArrayList<TrainingSet>();

    @Column(name = "sets_record")
    private String setsRecordAsString;

    @Column(name = "one_rm")
    private Double oneRM;

    @Column(name = "volume")
    private Double volume;

    @Column(name = "intensity")
    private Double intensity;

    @Column(name = "total_reps")
    private int totalReps;

    @Column(name = "top_set")
    private String topSet;









}





