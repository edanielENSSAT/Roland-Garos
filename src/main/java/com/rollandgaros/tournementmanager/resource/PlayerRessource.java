package com.rollandgaros.tournementmanager.resource;

import com.rollandgaros.tournementmanager.model.Player;
import com.rollandgaros.tournementmanager.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerRessource {
    private final PlayerService playerService;

    public PlayerRessource(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Player>> getAllPlayer(){
        List<Player> players = playerService.findAllPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/allByWonMatchWomen")
    public ResponseEntity<List<Player>> getAllPlayerByWonMatchWomen(){
        List<Player> players = playerService.findAllByWonMatchsWomen();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/allByWonMatchMen")
    public ResponseEntity<List<Player>> getAllPlayerByWonMatchMen(){
        List<Player> players = playerService.findAllByWonMatchsMen();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/allByPlayTimeMen")
    public ResponseEntity<List<Player>> getAllPlayerByPlayTimeMen(){
        List<Player> players = playerService.findAllByPlayTimeMen();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/allByPlayTimeWomen")
    public ResponseEntity<List<Player>> getAllPlayerByPlayTimeWomen(){
        List<Player> players = playerService.findAllByPlayTimeWomen();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable("id") Long id){
        Player player = playerService.findPlayerById(id);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @GetMapping("/findAllWomen")
    public ResponseEntity<List<Player>> getWomenPlayer(){
        List<Player> players = playerService.getAllWomen();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/findAllMen")
    public ResponseEntity<List<Player>> getMenPlayers(){
        List<Player> players = playerService.getAllMen();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/findAllByName")
    public ResponseEntity<List<Player>> getAllByName(){
        List<Player> players = playerService.getAllByName();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/findAllByRank")
    public ResponseEntity<List<Player>> getAllByRank(){
        List<Player> players = playerService.getAllByRank();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player newPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
        Player updatePlayer = playerService.updatePlayer(player);
        return new ResponseEntity<>(updatePlayer, HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable("id") Long id) {
        playerService.deletePlayer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
