package de.tkay.foosball.player.model.dto;

import de.tkay.foosball.player.model.database.Player;

import java.time.LocalDateTime;

public class PlayerSummary extends Player {
    private Long playedGames;

    public PlayerSummary() {
    }

    public PlayerSummary(Integer id,
                         String firstName,
                         String lastName,
                         String email,
                         LocalDateTime creationDate,
                         LocalDateTime updateDate,
                         Long playedGames) {
        super(id, firstName, lastName, email, creationDate, updateDate);
        this.playedGames = playedGames;
    }

    public Long getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(Long playedGames) {
        this.playedGames = playedGames;
    }
}
