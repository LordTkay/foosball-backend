package de.tkay.foosball.game;

import de.tkay.foosball.game.model.database.Game;
import de.tkay.foosball.game.model.database.GameRepository;
import de.tkay.foosball.game.model.dto.GameCreate;
import de.tkay.foosball.game.model.dto.GameSummary;
import de.tkay.foosball.player.model.database.Player;
import de.tkay.foosball.player.model.database.PlayerRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {

    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;

    public GameController(GameRepository gameRepository,
                          PlayerRepository playerRepository) {
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
    }


    @GetMapping("/games")
    public @ResponseBody Iterable<GameSummary> getGames() {
        return this.gameRepository.getGames();
    }

    @PutMapping("/game")
    public @ResponseBody GameSummary addGame(@RequestBody GameCreate game) {
        Player blackAttackPlayer = this.playerRepository.findById(game.getTeams().getBlack().getAttacker()).orElseThrow();
        Player blackDefensePlayer = this.playerRepository.findById(game.getTeams().getBlack().getDefender()).orElseThrow();
        Player yellowAttackPlayer = this.playerRepository.findById(game.getTeams().getYellow().getAttacker()).orElseThrow();
        Player yellowDefensePlayer = this.playerRepository.findById(game.getTeams().getYellow().getDefender()).orElseThrow();

        Game newGame = new Game(
                game.getPlayDate(),
                blackAttackPlayer,
                blackDefensePlayer,
                yellowAttackPlayer,
                yellowDefensePlayer,
                game.getScores().getBlack(),
                game.getScores().getYellow()
        );
        Game savedGame = gameRepository.save(newGame);
        return gameRepository.getGame(savedGame.getId());
    }
}
