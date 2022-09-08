package de.tkay.foosball.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime playDateTime;




    @Column(nullable = false)
    private boolean blackWon;

}
