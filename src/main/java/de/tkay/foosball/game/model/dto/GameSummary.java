package de.tkay.foosball.game.model.dto;

import java.time.LocalDateTime;

public class GameSummary {
    private Integer id;
    private LocalDateTime playDateTime;
    private Integer blackAttackPlayerId;
    private Integer blackDefensePlayerId;
    private Integer yellowAttackPlayerId;
    private Integer yellowDefensePlayerId;
    private boolean blackWon;

    public GameSummary() {
    }

    public GameSummary(Integer id, LocalDateTime playDateTime, Integer blackAttackPlayerId, Integer blackDefensePlayerId, Integer yellowAttackPlayerId, Integer yellowDefensePlayerId, boolean blackWon) {
        this.id = id;
        this.playDateTime = playDateTime;
        this.blackAttackPlayerId = blackAttackPlayerId;
        this.blackDefensePlayerId = blackDefensePlayerId;
        this.yellowAttackPlayerId = yellowAttackPlayerId;
        this.yellowDefensePlayerId = yellowDefensePlayerId;
        this.blackWon = blackWon;
    }

    public LocalDateTime getPlayDateTime() {
        return playDateTime;
    }

    public void setPlayDateTime(LocalDateTime playDateTime) {
        this.playDateTime = playDateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isBlackWon() {
        return blackWon;
    }

    public void setBlackWon(boolean blackWon) {
        this.blackWon = blackWon;
    }

    public Integer getBlackAttackPlayerId() {
        return blackAttackPlayerId;
    }

    public void setBlackAttackPlayerId(Integer blackAttackPlayerId) {
        this.blackAttackPlayerId = blackAttackPlayerId;
    }

    public Integer getBlackDefensePlayerId() {
        return blackDefensePlayerId;
    }

    public void setBlackDefensePlayerId(Integer blackDefensePlayerId) {
        this.blackDefensePlayerId = blackDefensePlayerId;
    }

    public Integer getYellowAttackPlayerId() {
        return yellowAttackPlayerId;
    }

    public void setYellowAttackPlayerId(Integer yellowAttackPlayerId) {
        this.yellowAttackPlayerId = yellowAttackPlayerId;
    }

    public Integer getYellowDefensePlayerId() {
        return yellowDefensePlayerId;
    }

    public void setYellowDefensePlayerId(Integer yellowDefensePlayerId) {
        this.yellowDefensePlayerId = yellowDefensePlayerId;
    }
}
