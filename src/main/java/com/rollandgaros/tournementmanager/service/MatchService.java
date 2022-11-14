package com.rollandgaros.tournementmanager.service;

import com.rollandgaros.tournementmanager.exception.MatchNotFoundExecption;
import com.rollandgaros.tournementmanager.model.Match;
import com.rollandgaros.tournementmanager.repo.MatchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Properties;


@Service
public class MatchService {
    private final MatchRepo matchRepo;

    public MatchService(MatchRepo matchRepo){this.matchRepo=matchRepo;}

    @Autowired

    public Match addMatch(Match match){return  matchRepo.save(match);}

    public List<Match> findAllMatches(){return matchRepo.findAll();}

    public Match updateMatch(Match match){return matchRepo.save(match);}

    public Match findMatchById(Long id){
        return matchRepo.findMatchById(id)
                .orElseThrow(() -> new MatchNotFoundExecption("Match by id" + id + "was not found"));
    }

    public void deleteMatch(Long id){matchRepo.deleteMatchById(id);}
}