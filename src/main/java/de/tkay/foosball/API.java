package de.tkay.foosball;

import de.tkay.foosball.model.database.Game;
import de.tkay.foosball.model.database.GameRepository;
import de.tkay.foosball.model.database.Player;
import de.tkay.foosball.model.database.PlayerRepository;
import de.tkay.foosball.model.dto.GameSummary;
import de.tkay.foosball.model.dto.GameCreate;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;

@RestController
public class API {

    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;
    private final EntityManager entityManager;

    public API(PlayerRepository playerRepository,
               GameRepository gameRepository,
               EntityManager entityManager) {
        this.playerRepository = playerRepository;
        this.gameRepository = gameRepository;
        this.entityManager = entityManager;
    }

    @GetMapping("/players")
    public @ResponseBody Iterable<Player> getPlayers() {
        return playerRepository.findAll();
    }

    @PutMapping("/player")
    public @ResponseBody Player addPlayer(@RequestBody Player player) {
        Player newPlayer = new Player(player.getFirstName(), player.getLastName(), player.getEmail());
        return playerRepository.save(newPlayer);
    }

    @DeleteMapping("/player/{id}")
    public @ResponseBody Integer deletePlayer(@PathVariable Integer id) {
        // ToDo Returning an error if the does not exist!
        playerRepository.deleteById(id);
        return id;
    }

    @PatchMapping("/player/{id}")
    public @ResponseBody Player editPlayer(@PathVariable Integer id,
                                           @RequestBody Player editedPlayer) {
        Player player = playerRepository.findById(id).orElseThrow();
        player.setFirstName(editedPlayer.getFirstName());
        player.setLastName(editedPlayer.getLastName());
        player.setEmail(editedPlayer.getEmail());
        playerRepository.save(player);
        return player;
    }


    @GetMapping("/games")
    public @ResponseBody Iterable<GameSummary> getGames() {
        return this.entityManager.createQuery("""
                select new de.tkay.foosball.model.dto.GameSummary (
                    g.id,
                    g.playDateTime,
                    g.blackAttackPlayer.id,
                    g.blackDefensePlayer.id,
                    g.yellowAttackPlayer.id,
                    g.yellowDefensePlayer.id,
                    g.blackWon
                )
                from Game g
                """, GameSummary.class).getResultList();
    }

    @PostMapping("/game")
    public @ResponseBody Game addGame(@RequestBody GameCreate game) {
        Player blackAttackPlayer = this.playerRepository.findById(game.getBlackAttackPlayerId()).orElseThrow();
        Player blackDefensePlayer = this.playerRepository.findById(game.getBlackDefensePlayerId()).orElseThrow();
        Player yellowAttackPlayer = this.playerRepository.findById(game.getYellowAttackPlayerId()).orElseThrow();
        Player yellowDefensePlayer = this.playerRepository.findById(game.getYellowDefensePlayerId()).orElseThrow();
        Game newGame = new Game(blackAttackPlayer, blackDefensePlayer, yellowAttackPlayer, yellowDefensePlayer, game.isBlackWon());
        return gameRepository.save(newGame);
    }
}
