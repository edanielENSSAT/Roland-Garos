package com.rollandgaros.tournementmanager.service;

import com.rollandgaros.tournementmanager.exception.PlayerNotFoundException;
import com.rollandgaros.tournementmanager.exception.TrainerNotFoundException;
import com.rollandgaros.tournementmanager.model.Player;
import com.rollandgaros.tournementmanager.model.Trainer;
import com.rollandgaros.tournementmanager.repo.TrainerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {
    private final TrainerRepo trainerRepo;

    @Autowired
    public TrainerService(TrainerRepo trainerRepo){this.trainerRepo=trainerRepo;}

    public Trainer addTrainer(Trainer trainer){return this.trainerRepo.save(trainer);}

    public Trainer updateTrainer(Trainer trainer){return this.trainerRepo.save(trainer);}

    public List<Trainer> findAllTrainers(){return this.trainerRepo.findAll();}

    public Trainer findTrainerById(Long id){
        return trainerRepo.findTrainerById(id)
                .orElseThrow(() -> new TrainerNotFoundException("Trainer by id" + id + "was not found"));
    }

    public void deleteTrainer(Long id){
        trainerRepo.deleteTrainerById(id);
    }
}
