package com.rollandgaros.tournementmanager.service;

import com.rollandgaros.tournementmanager.exception.EntrainementNotFoundExecption;
import com.rollandgaros.tournementmanager.model.Match;
import com.rollandgaros.tournementmanager.model.Entrainement;
import com.rollandgaros.tournementmanager.repo.EntrainementRepo;
import com.rollandgaros.tournementmanager.repo.MatchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Properties;


@Service
public class EntrainementService {
    private final EntrainementRepo entrainementRepo;

    public EntrainementService(EntrainementRepo entrainementRepo){this.entrainementRepo=entrainementRepo;}

    @Autowired

    public Entrainement addEntrainement(Entrainement entrainement){return  entrainementRepo.save(entrainement);}

    public  List<Entrainement> findAllEntrainements(){return entrainementRepo.findAll();}

    public Entrainement updateEntrainement(Entrainement entrainement){return entrainementRepo.save(entrainement);}

    public Entrainement findEntrainementsById(Long id){
        return entrainementRepo.findEntrainementById(id)
                .orElseThrow(() -> new EntrainementNotFoundExecption("Entrainement by id" + id + "was not found"));
    }

    public void deleteEntrainement(Long id){entrainementRepo.deleteEntrainementById(id);}
}
