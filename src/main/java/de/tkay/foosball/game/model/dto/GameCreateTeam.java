package de.tkay.foosball.game.model.dto;

public class GameCreateTeam {
    private Integer attacker;
    private Integer defender;

    public GameCreateTeam() {
    }

    public GameCreateTeam(Integer attacker, Integer defender) {
        this.attacker = attacker;
        this.defender = defender;
    }

    public Integer getAttacker() {
        return attacker;
    }

    public void setAttacker(Integer attacker) {
        this.attacker = attacker;
    }

    public Integer getDefender() {
        return defender;
    }

    public void setDefender(Integer defender) {
        this.defender = defender;
    }
}
