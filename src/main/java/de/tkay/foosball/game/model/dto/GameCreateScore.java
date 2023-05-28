package de.tkay.foosball.game.model.dto;

public class GameCreateScore {
    private Integer yellow;
    private Integer black;

    public GameCreateScore() {
    }

    public GameCreateScore(Integer yellow, Integer black) {
        this.yellow = yellow;
        this.black = black;
    }

    public Integer getYellow() {
        return yellow;
    }

    public void setYellow(Integer yellow) {
        this.yellow = yellow;
    }

    public Integer getBlack() {
        return black;
    }

    public void setBlack(Integer black) {
        this.black = black;
    }
}
