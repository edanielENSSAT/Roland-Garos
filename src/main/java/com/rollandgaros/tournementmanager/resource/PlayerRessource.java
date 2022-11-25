package com.rollandgaros.tournementmanager.resource;

import com.rollandgaros.tournementmanager.model.Player;
import com.rollandgaros.tournementmanager.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/management/management/player")
public class PlayerRessource {
    private final PlayerService playerService;

    public PlayerRessource(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/all")
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PLAYER','ROLE_MATCH')") Pas nécessaire : accessible visiteurs
    public ResponseEntity<List<Player>> getAllPlayer(){
        List<Player> players = playerService.findAllPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/allByWonMatchWomen")
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PLAYER','ROLE_MATCH')") Pas nécessaire : accessible visiteurs
    public ResponseEntity<List<Player>> getAllPlayerByWonMatchWomen(){
        List<Player> players = playerService.findAllByWonMatchsWomen();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/allByPlayTimeWomen")
    public ResponseEntity<List<Player>> getAllPlayerByPlayTimeWomen(){
        List<Player> players = playerService.findAllByPlayTimeWomen();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/allByWonMatchMen")
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PLAYER','ROLE_MATCH')") Pas nécessaire : accessible visiteurs
    public ResponseEntity<List<Player>> getAllPlayerByWonMatchMen(){
        List<Player> players = playerService.findAllByWonMatchsMen();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/allByPlayTimeMen")
    public ResponseEntity<List<Player>> getAllPlayerByPlayTimeMen(){
        List<Player> players = playerService.findAllByPlayTimeMen();
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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deletePlayer(@PathVariable("id") Long id) {
        playerService.deletePlayer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
