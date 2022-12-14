package de.tkay.foosball;

import de.tkay.foosball.models.database.Game;
import de.tkay.foosball.models.database.GameRepository;
import de.tkay.foosball.models.database.Player;
import de.tkay.foosball.models.database.PlayerRepository;
import de.tkay.foosball.models.dto.GameSummary;
import de.tkay.foosball.models.dto.GameCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;

@RestController
public class API {

    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;

    @Autowired
    EntityManager entityManager;

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
        Player newPlayer = new Player(player.getFirstName(), player.getLastName(), player.getEmail());
        return playerRepository.save(newPlayer);
    }


    @GetMapping("/games")
    public @ResponseBody Iterable<GameSummary> getGames() {
        return this.entityManager.createQuery("""
                select new de.tkay.foosball.models.dto.GameSummary (
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
