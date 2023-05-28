package de.tkay.foosball.game.model.database;

import de.tkay.foosball.player.model.database.Player;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime playDate;

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
    private Integer yellowScore;

    @Column(nullable = false)
    private Integer blackScore;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateDate;

    public Game() {
    }

    public Game(LocalDateTime playDate,
                Player blackAttackPlayer,
                Player blackDefensePlayer,
                Player yellowAttackPlayer,
                Player yellowDefensePlayer,
                Integer blackScore,
                Integer yellowScore) {
        this.playDate = playDate;
        this.blackAttackPlayer = blackAttackPlayer;
        this.blackDefensePlayer = blackDefensePlayer;
        this.yellowAttackPlayer = yellowAttackPlayer;
        this.yellowDefensePlayer = yellowDefensePlayer;
        this.yellowScore = yellowScore;
        this.blackScore = blackScore;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getPlayDate() {
        return playDate;
    }

    public void setPlayDate(LocalDateTime playDateTime) {
        this.playDate = playDateTime;
    }

    public Player getBlackAttackPlayer() {
        return blackAttackPlayer;
    }

    public void setBlackAttackPlayer(Player blackAttackPlayer) {
        this.blackAttackPlayer = blackAttackPlayer;
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

    public Integer getYellowScore() {
        return yellowScore;
    }

    public void setYellowScore(Integer yellowScore) {
        this.yellowScore = yellowScore;
    }

    public Integer getBlackScore() {
        return blackScore;
    }

    public void setBlackScore(Integer blackScore) {
        this.blackScore = blackScore;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }
}
