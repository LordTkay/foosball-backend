package de.tkay.foosball.player;

import de.tkay.foosball.player.model.database.Player;
import de.tkay.foosball.player.model.database.PlayerRepository;
import de.tkay.foosball.player.model.dto.PlayerSummary;
import org.springframework.web.bind.annotation.*;

@RestController()
public class PlayerController {

    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping("/players")
    public @ResponseBody Iterable<PlayerSummary> getPlayers() {
        return playerRepository.getPlayersWithStats();
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
}
