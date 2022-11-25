package com.rollandgaros.tournementmanager.resource;


import com.rollandgaros.tournementmanager.model.Trainer;
import com.rollandgaros.tournementmanager.service.TrainerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainer")
public class TrainerRessource {
    private final TrainerService trainerService;

    public TrainerRessource(TrainerService trainerService){this.trainerService=trainerService;}

    @GetMapping("/all")
    public ResponseEntity<List<Trainer>> getAllTrainer(){
        List<Trainer> trainers = trainerService.findAllTrainers();
        return new ResponseEntity<>(trainers, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Trainer> getPTrainerById(@PathVariable("id") Long id){
        Trainer trainer = trainerService.findTrainerById(id);
        return new ResponseEntity<>(trainer, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Trainer> addTrainer(@RequestBody Trainer trainer) {
        Trainer newtrainer = trainerService.addTrainer(trainer);
        return new ResponseEntity<>(newtrainer, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Trainer> updateTrainer(@RequestBody Trainer trainer) {
        Trainer updateTrainer = trainerService.updateTrainer(trainer);
        return new ResponseEntity<>(updateTrainer, HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteTrainer(@PathVariable("id") Long id) {
        trainerService.deleteTrainer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
