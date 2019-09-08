package com.Model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data

@Entity
@NamedQueries({
        @NamedQuery(name = "singleSession", query = "FROM TrainingSession T WHERE T.date = :singleDate"),
        @NamedQuery(name = "getAllSessions", query = "SELECT s FROM TrainingSession s"),
        @NamedQuery(name = "betweenDates", query = "FROM TrainingSession T WHERE T.date BETWEEN :firstDate AND :secondDate")
})


@Table(name = "training_session")
public class TrainingSession {

    @Id
    @Column(name = "session_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sessionId;

    @Column(name = "date")
    private LocalDate date;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "trainingSession", cascade = CascadeType.ALL)
    private List<Exercise> exerciseList = new ArrayList<>();

    @Column(name = "comments")
    private String comments;

    public TrainingSession() {

    }

}
