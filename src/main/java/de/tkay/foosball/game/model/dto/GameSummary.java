package de.tkay.foosball.game.model.dto;

import de.tkay.foosball.game.enumeration.Winner;

import java.time.LocalDateTime;

public class GameSummary extends GameCreate {

    private Integer id;
    private Winner winner;
    private boolean perfectWin;

    public GameSummary() {
    }

    public GameSummary(Integer id,
                       LocalDateTime playDate,
                       Integer yellowAttackPlayerId,
                       Integer yellowDefensePlayerId,
                       Integer blackAttackPlayerId,
                       Integer blackDefensePlayerId,
                       Integer yellowScore,
                       Integer blackScore,
                       String winner,
                       boolean perfectWin) {
        super(playDate,
                new GameCreateTeams(
                        new GameCreateTeam(yellowAttackPlayerId, yellowDefensePlayerId),
                        new GameCreateTeam(blackAttackPlayerId, blackDefensePlayerId)
                ),
                new GameCreateScore(yellowScore, blackScore)
        );
        this.id = id;
        this.winner = Winner.valueOf(winner);
        this.perfectWin = perfectWin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Winner getWinner() {
        return winner;
    }

    public void setWinner(Winner winner) {
        this.winner = winner;
    }

    public boolean isPerfectWin() {
        return perfectWin;
    }

    public void setPerfectWin(boolean perfectWin) {
        this.perfectWin = perfectWin;
    }
}
