package com.rollandgaros.tournementmanager.service;

import com.rollandgaros.tournementmanager.exception.PlayerNotFoundException;
import com.rollandgaros.tournementmanager.model.Player;
import com.rollandgaros.tournementmanager.repo.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepo playerRepo;

    @Autowired
    public PlayerService(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    public Player addPlayer(Player player) {return playerRepo.save(player);}

    public List<Player> findAllPlayers(){return playerRepo.findAll();}

    public List<Player> findAllByWonMatchs(){return playerRepo.findAllByWonMatchs();}

    public List<Player> findAllByPlayTime(){return playerRepo.findAllByPlayTime();}

    public Player updatePlayer(Player player) {
        return playerRepo.save(player);
    }

    public Player findPlayerById(Long id){
        return playerRepo.findPlayerById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player by id" + id + "was not found"));
    }


    public void deletePlayer(Long id){
        playerRepo.deletePlayerById(id);
    }
}
