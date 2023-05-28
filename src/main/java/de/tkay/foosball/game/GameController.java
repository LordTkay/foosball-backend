package de.tkay.foosball.game;

import de.tkay.foosball.game.model.database.Game;
import de.tkay.foosball.game.model.database.GameRepository;
import de.tkay.foosball.game.model.dto.GameCreate;
import de.tkay.foosball.game.model.dto.GameSummary;
import de.tkay.foosball.player.model.database.Player;
import de.tkay.foosball.player.model.database.PlayerRepository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;

@RestController
public class GameController {

    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;
    private final EntityManager entityManager;

    public GameController(EntityManager entityManager,
                          GameRepository gameRepository,
                          PlayerRepository playerRepository) {
        this.entityManager = entityManager;
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
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
