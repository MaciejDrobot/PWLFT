package com.Model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data

@Entity
@NamedQuery(name = "primaryExcercises",query = "FROM Excercise E WHERE E.liftMark = :liftMark")
@Table(name = "excercise")
public class Excercise extends SessionStats {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "date")
    private LocalDate date;

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


    @Override
    public String toString() {
        return "Excercise{" +
                "name='" + name + '\'' +
                ", liftMark='" + liftMark + '\'' +
                ", repetitionMark='" + repetitionMark + '\'' +
                ", setsRecord=" + setsRecord +
                ", setsRecordAsString='" + setsRecordAsString + '\'' +
                ", oneRM=" + oneRM +
                ", volume=" + volume +
                ", intensity=" + intensity +
                ", totalReps=" + totalReps +
                ", topSet='" + topSet + '\'' +
                '}';
    }
}





