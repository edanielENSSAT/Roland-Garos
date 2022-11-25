package com.rollandgaros.tournementmanager.service;

import com.rollandgaros.tournementmanager.exception.TrainingNotFoundException;
import com.rollandgaros.tournementmanager.model.Training;
import com.rollandgaros.tournementmanager.repo.TrainingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {
    private final TrainingRepo trainingRepo;

    public TrainingService(TrainingRepo trainingRepo){this.trainingRepo=trainingRepo;}

    @Autowired

    public Training addTraining(Training training){return trainingRepo.save(training);}

    public List<Training> findAllTrainings(){return trainingRepo.findAll();}

    public Training updateTraining(Training training){return trainingRepo.save(training);}

    public Training findTrainingById(Long id){
        return trainingRepo.findTrainingById(id)
                .orElseThrow(() -> new TrainingNotFoundException("Training by id" + id + "was not found"));
    }

    public void deleteTraining(Long id){trainingRepo.deleteTrainingById(id);}
}