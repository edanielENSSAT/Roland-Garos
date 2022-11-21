package com.rollandgaros.tournementmanager;

import com.rollandgaros.tournementmanager.model.Player;
import com.rollandgaros.tournementmanager.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/management/player")
public class PlayerRessource {
    private final PlayerService playerService;

    public PlayerRessource(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PLAYER','ROLE_MATCH')")
    public ResponseEntity<List<Player>> getAllPlayer(){
        List<Player> players = playerService.findAllPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/allByWonMatch")
    public ResponseEntity<List<Player>> getAllPlayerByWonMatch(){
        List<Player> players = playerService.findAllByWonMatchs();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/allByPlayTime")
    public ResponseEntity<List<Player>> getAllPlayerByPlayTime(){
        List<Player> players = playerService.findAllByPlayTime();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PLAYER','ROLE_MATCH')")
    public ResponseEntity<Player> getPlayerById(@PathVariable("id") Long id){
        Player player = playerService.findPlayerById(id);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }


    @PostMapping("/add")
    @PreAuthorize("hasAuthority('player:write')")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player newPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('player:write')")
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
