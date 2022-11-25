package com.rollandgaros.tournementmanager.service;

import com.rollandgaros.tournementmanager.exception.MatchNotFoundException;
import com.rollandgaros.tournementmanager.exception.PlayerNotFoundException;
import com.rollandgaros.tournementmanager.model.TennisMatch;
import com.rollandgaros.tournementmanager.repo.MatchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MatchService {
    private final MatchRepo matchRepo;

    public MatchService(MatchRepo matchRepo){this.matchRepo=matchRepo;}

    @Autowired

    public TennisMatch addMatch(TennisMatch match){return matchRepo.save(match);}

    public List<TennisMatch> findAllMatches(){return matchRepo.findAll();}

    public TennisMatch updateMatch(TennisMatch match){return matchRepo.save(match);}

    public TennisMatch findMatchById(Long id){
        return matchRepo.findMatchById(id)
                .orElseThrow(() -> new MatchNotFoundException("Match by id" + id + "was not found"));
    }

    public List<TennisMatch> findMatchByPlayer(Long player){
        return matchRepo.findMatchByPlayer(player)
                .orElseThrow(() -> new PlayerNotFoundException("Match by player" + player + "was not found"));
    }

    public void deleteMatch(Long id){matchRepo.deleteMatchById(id);}
}
