package com.rollandgaros.tournementmanager.service;

import com.rollandgaros.tournementmanager.exception.MatchNotFoundException;
import com.rollandgaros.tournementmanager.exception.SetNotFoundException;
import com.rollandgaros.tournementmanager.model.TennisSet;
import com.rollandgaros.tournementmanager.repo.SetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SetService {
    private final SetRepo setRepo;

    public SetService(SetRepo setRepo){this.setRepo=setRepo;}

    @Autowired

    public List<TennisSet> findAllSet(){return setRepo.findAll();}

    public TennisSet addSet(TennisSet set){
        return setRepo.save(set);
    }

    public TennisSet updateSet(TennisSet set){return setRepo.save(set);}

    public void deleteSet(Long id){setRepo.deleteSetById(id);}


    public List<TennisSet> findAllSetByMatch(Long id){
        return setRepo.findAllSetByMatchId(id)
                .orElseThrow(()-> new MatchNotFoundException("Match by id" + id + "was not found"));
    }

    public TennisSet findSetById(Long id){
        if(setRepo.findAll().isEmpty())
            throw new SetNotFoundException("Le set demandé n'existe pas");
        return setRepo.findSetById(id);
    }

    public int getNbSet(Long matchId){
        return setRepo.getNbSets(matchId);
    }
}
