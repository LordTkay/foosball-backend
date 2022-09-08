package de.tkay.foosball.models.database;

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

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Player blackAttackPlayer;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Player blackDefensePlayer;


    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Player yellowAttackPlayer;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Player yellowDefensePlayer;


    @Column(nullable = false)
    private boolean blackWon;

    public Game() {
    }

    public Game(Player blackAttackPlayer, Player blackDefensePlayer, Player yellowAttackPlayer, Player yellowDefensePlayer, boolean blackWon) {
        this.blackAttackPlayer = blackAttackPlayer;
        this.blackDefensePlayer = blackDefensePlayer;
        this.yellowAttackPlayer = yellowAttackPlayer;
        this.yellowDefensePlayer = yellowDefensePlayer;
        this.blackWon = blackWon;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getPlayDateTime() {
        return playDateTime;
    }

    public Player getBlackAttackPlayer() {
        return blackAttackPlayer;
    }

    public void setBlackAttackPlayer(Player blackAttackPlayer) {
        this.blackAttackPlayer = blackAttackPlayer;
    }

    public boolean isBlackWon() {
        return blackWon;
    }

    public void setBlackWon(boolean blackWon) {
        this.blackWon = blackWon;
    }

    public Player getBlackDefensePlayer() {
        return blackDefensePlayer;
    }

    public void setBlackDefensePlayer(Player blackDefensePlayer) {
        this.blackDefensePlayer = blackDefensePlayer;
    }

    public Player getYellowAttackPlayer() {
        return yellowAttackPlayer;
    }

    public void setYellowAttackPlayer(Player yellowAttackPlayer) {
        this.yellowAttackPlayer = yellowAttackPlayer;
    }

    public Player getYellowDefensePlayer() {
        return yellowDefensePlayer;
    }

    public void setYellowDefensePlayer(Player yellowDefensePlayer) {
        this.yellowDefensePlayer = yellowDefensePlayer;
    }
}
