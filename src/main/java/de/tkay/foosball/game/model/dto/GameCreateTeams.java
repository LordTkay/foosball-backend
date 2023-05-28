package de.tkay.foosball.game.model.dto;

public class GameCreateTeams {
    private GameCreateTeam yellow;
    private GameCreateTeam black;

    public GameCreateTeams() {
    }

    public GameCreateTeams(GameCreateTeam yellow, GameCreateTeam black) {
        this.yellow = yellow;
        this.black = black;
    }

    public GameCreateTeam getYellow() {
        return yellow;
    }

    public void setYellow(GameCreateTeam yellow) {
        this.yellow = yellow;
    }

    public GameCreateTeam getBlack() {
        return black;
    }

    public void setBlack(GameCreateTeam black) {
        this.black = black;
    }
}
