package de.tkay.foosball;

import de.tkay.foosball.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public @ResponseBody Player addPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }


    @GetMapping("/games")
    public @ResponseBody Iterable<Game> getGames() {
        return gameRepository.findAll();
    }

    @PostMapping("/game")
    public @ResponseBody Game addGame(@RequestBody Game game) {
        return gameRepository.save(game);
    }
}
