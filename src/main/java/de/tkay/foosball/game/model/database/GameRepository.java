package de.tkay.foosball.game.model.database;

import de.tkay.foosball.game.model.dto.GameSummary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Integer> {

    @Query("""
SELECT new de.tkay.foosball.game.model.dto.GameSummary(
    g.id,
    g.playDate,
    g.yellowAttackPlayer.id,
    g.yellowDefensePlayer.id,
    g.blackAttackPlayer.id,
    g.blackDefensePlayer.id,
    g.yellowScore,
    g.blackScore,
    CASE WHEN g.blackScore > g.yellowScore THEN 'BLACK'
         WHEN g.blackScore < g.yellowScore THEN 'YELLOW'
         ELSE 'DRAW' END,
    CASE WHEN (g.blackScore = 0 AND g.yellowScore >= 6) OR (g.blackScore >= 6 AND g.yellowScore = 0)
         THEN true ELSE false END
) FROM Game AS g
""")
    List<GameSummary> getAllGames();

}

//               g.blackAttackPlayer.id,
//               g.blackDefensePlayer.id,
//               g.yellowAttackPlayer.id,
//               g.yellowDefensePlayer.id,
