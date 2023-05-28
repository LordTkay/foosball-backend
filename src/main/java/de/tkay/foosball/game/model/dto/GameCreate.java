package de.tkay.foosball.game.model.dto;

import java.time.LocalDateTime;

public class GameCreate {
    private LocalDateTime playDate;
    private GameCreateTeams teams;
    private GameCreateScore scores;

    public GameCreate() {
    }

    public GameCreate(LocalDateTime playDate, GameCreateTeams teams, GameCreateScore scores) {
        this.playDate = playDate;
        this.teams = teams;
        this.scores = scores;
    }

    public LocalDateTime getPlayDate() {
        return playDate;
    }

    public void setPlayDate(LocalDateTime playDateTime) {
        this.playDate = playDateTime;
    }

    public GameCreateTeams getTeams() {
        return teams;
    }

    public void setTeams(GameCreateTeams teams) {
        this.teams = teams;
    }

    public GameCreateScore getScores() {
        return scores;
    }

    public void setScores(GameCreateScore scores) {
        this.scores = scores;
    }
}
