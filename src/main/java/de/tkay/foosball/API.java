package de.tkay.foosball;

import de.tkay.foosball.models.database.Game;
import de.tkay.foosball.models.database.GameRepository;
import de.tkay.foosball.models.database.Player;
import de.tkay.foosball.models.database.PlayerRepository;
import de.tkay.foosball.models.request.GameRequest;
import de.tkay.foosball.models.request.PlayerRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class API {

    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;

    public API(PlayerRepository playerRepository, GameRepository gameRepository) {
        this.playerRepository = playerRepository;
        this.gameRepository = gameRepository;
    }

    @GetMapping("/players")
    public @ResponseBody Iterable<Player> getPlayers() {
        return playerRepository.findAll();
    }

    @PostMapping("/player")
    public @ResponseBody Player addPlayer(@RequestBody PlayerRequest player) {
        Player newPlayer = new Player(player.getFirstName(), player.getLastName(), player.getEmail());
        return playerRepository.save(newPlayer);
    }


    @GetMapping("/games")
    public @ResponseBody Iterable<Game> getGames() {
        return gameRepository.findAll();
    }

    @PostMapping("/game")
    public @ResponseBody Game addGame(@RequestBody GameRequest game) {
        Player blackAttackPlayer = this.playerRepository.findById(game.getBlackAttackPlayerId()).orElseThrow();
        Player blackDefensePlayer = this.playerRepository.findById(game.getBlackDefensePlayerId()).orElseThrow();
        Player yellowAttackPlayer = this.playerRepository.findById(game.getYellowAttackPlayerId()).orElseThrow();
        Player yellowDefensePlayer = this.playerRepository.findById(game.getYellowDefensePlayerId()).orElseThrow();
        Game newGame = new Game(blackAttackPlayer, blackDefensePlayer, yellowAttackPlayer, yellowDefensePlayer, game.isBlackWon());
        return gameRepository.save(newGame);
    }
}
