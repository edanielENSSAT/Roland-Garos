package com.rollandgaros.tournementmanager.service;

import com.rollandgaros.tournementmanager.exception.MatchNotFoundExecption;
import com.rollandgaros.tournementmanager.exception.SetNotFoundExeption;
import com.rollandgaros.tournementmanager.model.Set;
import com.rollandgaros.tournementmanager.repo.SetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetService {
    private final SetRepo setRepo;

    public SetService(SetRepo setRepo){this.setRepo=setRepo;}

    @Autowired

    public List<Set> findAllSet(){return setRepo.findAll();}

    public Set addSet(Set set){return setRepo.save(set);}

    public Set updateSet(Set set){return setRepo.save(set);}

    public void deleteSet(Long id){setRepo.deleteSetById(id);}

    public List<Set> findAllSetByMatch(Long id){
        return setRepo.findAllSetByMatchId(id)
                .orElseThrow(()-> new MatchNotFoundExecption("Match by id" + id + "was not found"));
    }

    public Set findSetById(Long id){
        return setRepo.findSetById(id)
                .orElseThrow(() -> new SetNotFoundExeption("Set by id" + id + "was not found"));
    }
}
