package com.rollandgaros.tournementmanager.resource;


import com.rollandgaros.tournementmanager.model.Training;
import com.rollandgaros.tournementmanager.service.TrainingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/training")
public class TrainingRessource  {
    private final TrainingService trainingService;

    public TrainingRessource(TrainingService trainingService){this.trainingService =trainingService;}

    @GetMapping("/all")
    public ResponseEntity<List<Training>> getAllTrainings(){
        List<Training> trainings = trainingService.findAllTrainings();
        return new ResponseEntity<>(trainings, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Training> getTrainingById(@PathVariable("id") Long id){
        Training training = trainingService.findTrainingById(id);
        return new ResponseEntity<>( training, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Training> addTraining(@RequestBody Training training) {
        Training newTraining = trainingService.addTraining(training);
        return new ResponseEntity<>(newTraining, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Training> updateTraining(@RequestBody Training training) {
        Training updateTraining = trainingService.updateTraining(training);
        return new ResponseEntity<>(updateTraining, HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteTraining(@PathVariable("id") Long id) {
        trainingService.deleteTraining(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}