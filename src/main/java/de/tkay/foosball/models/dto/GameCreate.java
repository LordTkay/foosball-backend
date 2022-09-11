package de.tkay.foosball.models.dto;

public class GameCreate {
    private Integer blackAttackPlayerId;
    private Integer blackDefensePlayerId;
    private Integer yellowAttackPlayerId;
    private Integer yellowDefensePlayerId;
    private boolean blackWon;

    public GameCreate() {
    }

    public GameCreate(Integer blackAttackPlayerId, Integer blackDefensePlayerId, Integer yellowAttackPlayerId, Integer yellowDefensePlayerId, boolean blackWon) {
        this.blackAttackPlayerId = blackAttackPlayerId;
        this.blackDefensePlayerId = blackDefensePlayerId;
        this.yellowAttackPlayerId = yellowAttackPlayerId;
        this.yellowDefensePlayerId = yellowDefensePlayerId;
        this.blackWon = blackWon;
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

    public Integer getBlackAttackPlayerId() {
        return blackAttackPlayerId;
    }

    public void setBlackAttackPlayerId(Integer blackAttackPlayerId) {
        this.blackAttackPlayerId = blackAttackPlayerId;
    }

    public void setBlackAttackPlayerId(int blackAttackPlayerId) {
        this.blackAttackPlayerId = blackAttackPlayerId;
    }

    public boolean isBlackWon() {
        return blackWon;
    }

    public void setBlackWon(boolean blackWon) {
        this.blackWon = blackWon;
    }
}
