package de.tkay.foosball.player.model.database;

import de.tkay.foosball.player.model.dto.PlayerSummary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Integer> {

    @Query("""
        SELECT new de.tkay.foosball.player.model.dto.PlayerSummary(
            p.id,
            p.firstName,
            p.lastName,
            p.email,
            p.creationDate,
            p.updateDate,
            COUNT(g.id)
        ) FROM Player AS p
                 LEFT JOIN Game AS g
                           ON p.id = g.blackAttackPlayer.id
                               OR p.id = g.blackDefensePlayer.id
                               OR p.id = g.yellowAttackPlayer.id
                               OR p.id = g.yellowDefensePlayer.id
        GROUP BY p.id
    """)
    List<PlayerSummary> getPlayersWithStats();

}
